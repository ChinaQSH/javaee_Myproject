package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 15:00
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;
import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.bean.order.VO.OrderGetVO;
import com.nylg.javaee.bean.order.VO.OrderUpdateSpecVO;
import com.nylg.javaee.dao.OrderDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
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
