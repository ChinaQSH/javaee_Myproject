package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 15:00
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;
import com.nylg.javaee.bean.goods.Spec;
import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;
import com.nylg.javaee.bean.goods.VO.GetGoodsNameVO;
import com.nylg.javaee.bean.noReply.BO.SendCommentBO;
import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.CartList;
import com.nylg.javaee.bean.order.BO.OrderAddIndex;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.bean.order.VO.OrderGetVO;
import com.nylg.javaee.bean.order.VO.OrderInfoIndex;
import com.nylg.javaee.bean.order.VO.OrderUpdateSpecVO;
import com.nylg.javaee.bean.user.VO.UserId;
import com.nylg.javaee.bean.user.VO.UserOrderIndexVO;
import com.nylg.javaee.dao.OrderDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@Description:
 *
 */
public class OrderDaoImpl implements OrderDao {
    @Override
    public List<OrderGetVO> ordersByPage(OrderGetBO orderGetBO) {
//        动态sql
        HashMap<String, Object> map = dynamicSql(orderGetBO);
        String sql = (String) map.get("sql");
        List<Object> params = (List<Object>) map.get("params");
        params.add(orderGetBO.getPagesize());
        params.add((orderGetBO.getCurrentPage() - 1) * orderGetBO.getPagesize());
        QueryRunner runner = new QueryRunner(DruidUtils.getDataSource());
        String prefix_sql = "select id,userId,goodsName as goods,goodsDetailId,specName as spec," +
                "goodsNum,amount,stateId,nickname,name,address,phone from orders ";
        String suffix_sql = " limit ? offset ?";
        List<OrderGetVO> orderVOS = null;
        try {
            orderVOS = runner.query(prefix_sql + sql + suffix_sql, new BeanListHandler<OrderGetVO>(OrderGetVO.class), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderVOS;
    }

    private HashMap<String, Object> dynamicSql(OrderGetBO orderGetBO) {
        HashMap<String, Object> map = new HashMap<>();
//        动态sql操作
        String baseSql="where 1=1 ";
        ArrayList<Object> params = new ArrayList<>();
        if (!StringUtils.isEmpty(orderGetBO.getAddress())){
            baseSql=baseSql+"and address like ?";
            params.add("%"+orderGetBO.getAddress()+"%");
        }
        if (!StringUtils.isEmpty(orderGetBO.getGoods())){
            baseSql=baseSql+"and goodsName like ?";
            params.add("%"+orderGetBO.getGoods()+"%");
        }
        if (!StringUtils.isEmpty(String.valueOf(orderGetBO.getId()))){
            baseSql=baseSql+"and id=?";
            params.add(orderGetBO.getId());
        }
        if (!StringUtils.isEmpty(orderGetBO.getMoneyLimit1())){
            baseSql=baseSql+"and amount <= ?";
            params.add(orderGetBO.getMoneyLimit1());
        }
        if (!StringUtils.isEmpty(orderGetBO.getMoneyLimit2())){
            baseSql=baseSql+"and amount >= ?";
            params.add(orderGetBO.getMoneyLimit2());
        }
        if(!StringUtils.isEmpty(orderGetBO.getName())){
            baseSql = baseSql + " and name like ?";
            params.add("%" + orderGetBO.getName() + "%");
        }
        if(orderGetBO.getState() != -1){
            //如果等于-1，表示的是查询全部，如果不等于-1，表示需要查询某个状态下的订单
            baseSql = baseSql + " and stateId = ?";
            params.add(orderGetBO.getState());
        }
        map.put("sql",baseSql);
        map.put("params",params);
        return map;
    }

    @Override
    public int getTotal(OrderGetBO orderGetBO) {
        HashMap<String, Object> map = dynamicSql(orderGetBO);
        String  sql = (String) map.get("sql");
        List<Object> params = (List<Object>) map.get("params");
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Long query = null;
        try {
            query = queryRunner.query("select count(*) from orders " + sql, new ScalarHandler<>(), params.toArray());
            //query = runner.query("select count(*) from orders " + sql, new ScalarHandler<>(), params.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query.intValue();
    }

    @Override
    public order getOrder(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        order query = null;
        try {
            query = queryRunner.query("select id,amount,goodsNum as num,goodsDetailId,state,goodsName as goods from orders where id=?", new BeanHandler<order>(order.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<OrderUpdateSpecVO> getSpec(String goods) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        GoodId query = null;
        List<OrderUpdateSpecVO> orderUpdateSpecVOS=null;
        try {
            query = queryRunner.query("select id from goods where name=?", new BeanHandler<GoodId>(GoodId.class),goods);
            orderUpdateSpecVOS = queryRunner.query("select id,specName,unitPrice from spec where goodId=?", new BeanListHandler<OrderUpdateSpecVO>(OrderUpdateSpecVO.class), query.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderUpdateSpecVOS;
    }

    @Override
    public int changOrder(UpdeateOrderBO updeateOrderBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("update orders set stateId=? where id=?", updeateOrderBO.getState(), updeateOrderBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

return 200;
    }

    @Override
    public int deleteOrder(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from orders where id=?",id);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public UserOrderIndexVO getUserInfo(String token) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        UserOrderIndexVO query = null;
        try {
            query = queryRunner.query("select id,nickname,recipient,address,phone from user where email=?", new BeanHandler<>(UserOrderIndexVO.class),token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public Spec getSpecs(Integer goodsDetailId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Spec query = null;
        try {
            query = queryRunner.query("select id,specName,stockNum,unitPrice,goodId from spec where id=?", new BeanHandler<>(Spec.class), goodsDetailId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;

    }

    @Override
    public String getGoodName(Integer goodId) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());

        GetGoodsNameVO query = null;
        try {
            query = queryRunner.query("select name from goods where id=?", new BeanHandler<>(GetGoodsNameVO.class),goodId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.getName();
    }

    @Override
    public void insertOrder(UserOrderIndexVO userOrderIndexVO, Spec spec, String name, OrderAddIndex orderAddIndex) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into orders values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,now())",userOrderIndexVO.getId(),
                    spec.getId(),name,spec.getSpecName(),orderAddIndex.getNum(),orderAddIndex.getAmount(),orderAddIndex.getState(),
                    orderAddIndex.getState(),userOrderIndexVO.getNickname(),userOrderIndexVO.getRecipient(),userOrderIndexVO.getAddress(),
                    userOrderIndexVO.getPhone(),0);
            queryRunner.update("update spec set stockNum=? where id=?",spec.getStockNum()-orderAddIndex.getNum(),spec.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public List<OrderInfoIndex> getOrderByState(int state, String token) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<OrderInfoIndex> query = null;
        try {
            query = queryRunner.query("select o.id,o.state,o.goodsNum,o.amount,o.goodsDetailId,o.createtime,o.hasComment,g.id as ids,g.img,g.name,o.goodsDetailId as goodsDetailIds,s.specName as spec,s.unitPrice from orders o,goods g,spec s where s.goodId=g.id and state=? and o.nickname=? and o.goodsName=g.`name` and o.specName=s.specName", new BeanListHandler<>(OrderInfoIndex.class), state, token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public Object[] getNumber(int id) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Object[] query = new Object[0];
        try {
            query = queryRunner.query("select goodsNum,specName from orders where id=?", new ArrayHandler(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void updateSpecNum(Object []num) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Object[] query = new Object[0];
        try {
            query = queryRunner.query("select stockNum from spec where specName=?", new ArrayHandler(), num[1]);
            int num1= (Integer)query[0]+(Integer)num[0];
            queryRunner.update("update spec set stockNum=? where specName=?",num1,num[1]);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateOrder(CartList list) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("update orders set goodsNum=?,amount=?,stateId=?,state=?,amount=? where id=?", list.getGoodsNum(), list.getAmount(), 1, 1, list.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderInfoIndex> getOrderByStates(int state, String token) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<OrderInfoIndex> query = null;
        try {
            query = queryRunner.query("select o.id,o.state,o.goodsNum,o.amount,o.goodsDetailId,o.createtime,o.hasComment,g.id as ids,g.img,g.name,o.goodsDetailId as goodsDetailIds,s.specName as spec,s.unitPrice from orders o,goods g,spec s where s.goodId=g.id and o.nickname=? and o.goodsName=g.`name` and o.specName=s.specName", new BeanListHandler<>(OrderInfoIndex.class),token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void pay(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("update orders set stateId=?,state=? where id=?",1,1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void confirmReceive(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        int STATE=3;
        try {
            queryRunner.update("update orders set stateId=?,state=? where id=?",STATE,STATE,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendComment(SendCommentBO sendCommentBO,int userId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into reply values(null,?,?,?,0,now(),null,?,?,null)",userId,sendCommentBO.getGoodsId()
            ,sendCommentBO.getContent(),sendCommentBO.getScore(),sendCommentBO.getGoodsDetailId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getUserId(String token) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        UserId query = null;
        try {
            query = queryRunner.query("select id from user where email=?", new BeanHandler<>(UserId.class),token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query.getId();
    }

//    @Override
//    public OrderCurState getCurstate(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        OrderCurState query = null;
//        try {
//            query = queryRunner.query("select state as id from orders where id=?", new BeanHandler<OrderCurState>(OrderCurState.class), id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
//
//    @Override
//    public OrderCurSpec getOrderCurSpec(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        OrderCurSpec query = null;
//        try {
//            query = queryRunner.query("select goodsDetailId as id from orders where id=?", new BeanHandler<OrderCurSpec>(OrderCurSpec.class), id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
}
