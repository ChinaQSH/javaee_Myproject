package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:18
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.*;
import com.nylg.javaee.bean.goods.BO.AddSpecBO;
import com.nylg.javaee.bean.goods.BO.DeleteSpecBO;
import com.nylg.javaee.bean.goods.BO.GoodTypeBO;
import com.nylg.javaee.bean.goods.BO.UpdateSpecListBO;
import com.nylg.javaee.bean.goods.VO.GetGoodInfoVO;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.dao.GoodDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 *@Description:
 *
 */
public class GoodDaoImpl  implements GoodDao {
    @Override
    public List<GoodTypeVO> getType() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<GoodTypeVO> query = null;
        try {
            query = queryRunner.query("select * from goodtype", new BeanListHandler<GoodTypeVO>(GoodTypeVO.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query ;
    }

    @Override
    public int addType(GoodTypeBO goodTypeBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Long query = null;
        try {
            query = queryRunner.query("select count(*) from goodtype where name=?", new ScalarHandler<>(), goodTypeBO.getName());
            if (query.intValue()==0){
                queryRunner.update("insert into goodtype values (null,?)",goodTypeBO.getName());
                return 200;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 404;
    }

    @Override
    public List<GetGoodsVO> getGoodsByType(int typeId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<GetGoodsVO> query = null;
        try {
            query = queryRunner.query("select id,img,name,price,typeId,stockNum from goods where typeId=?", new BeanListHandler<GetGoodsVO>(GetGoodsVO.class), typeId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }
///添加商品信息到商品表
    @Override
    public void addGoods(Goods goods) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into goods values (null,?,?,?,?,?,?)",goods.getImg(),goods.getName(),goods.getPrice(),goods.getTypeId(),goods.getStokNum(),goods.getDescription());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getMaxId() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Integer query = null;
        try {
            query = queryRunner.query("select max(id) from goods", new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void addSpecList(Object[][] objects) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.batch("insert into spec values (null,?,?,?,?)", objects);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateGoods(Goods goods) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("update  goods set img=?,name=?,price=?,typeId=?,stockNum=?,description=? where id=?",goods.getImg(),goods.getName(),goods.getPrice(),goods.getTypeId(),goods.getStokNum(),goods.getDescription(),goods.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public void updateSpecList(Object[][] objects) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        try {
//            queryRunner.batch("update spec set id=?,specName=?,stockNum=?,unitPrice=? where goodId=?", objects);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public GetGoodInfoVO getGoodInfo(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        GetGoodInfoVO query = null;
        try {
            query = queryRunner.query("select id,img,name,description as `desc`,typeId,price as unitPrice from goods where id=?", new BeanHandler<GetGoodInfoVO>(GetGoodInfoVO.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public List<UpdateSpecListBO> getSpecInfo(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<UpdateSpecListBO> query = null;
        try {
            query = queryRunner.query("select id,specName,stockNum,unitPrice from spec where goodId=?", new BeanListHandler<UpdateSpecListBO>(UpdateSpecListBO.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int addSpec(AddSpecBO addSpecBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        int stockNum = Integer.valueOf(addSpecBO.getStockNum());
        double unitPrice = Double.valueOf(addSpecBO.getUnitPrice());
        int goodsId = Integer.valueOf(addSpecBO.getGoodsId());
        try {
            Long query = queryRunner.query("select count(*) from spec where specName=? and goodId=?", new ScalarHandler<>(), addSpecBO.getSpecName(),goodsId);
            if (query.intValue()==0){
                queryRunner.update("insert into spec values (null,?,?,?,?)", addSpecBO.getSpecName(), stockNum, unitPrice, goodsId);
                return 200;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 404;
    }

    @Override
    public int deleteSpec(DeleteSpecBO deleteSpecBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        int goodsId = Integer.parseInt(deleteSpecBO.getGoodsId());
        try {
            queryRunner.update("delete from spec where goodId=? and specName=?",goodsId,deleteSpecBO.getSpecName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public int deleteGoods(Integer id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from spec where goodId=?",id);
           queryRunner.update("delete from goods where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public int deleteType(Integer id) {
//        首先删除库存表的数据
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from goodtype where id=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public List<GoodTypeBO> selectGoodId(Integer id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<GoodTypeBO> query=null;
        try {
            query= queryRunner.query("select id from goods where typeId=?", new BeanListHandler<GoodTypeBO>(GoodTypeBO.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void deleteSpecId(GoodTypeBO goodId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from spec where goodId=?",goodId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGoodId(Integer id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from goods where typeId=?",id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public int getMaxstockNum() {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        Integer query = null;
//        try {
//            query = queryRunner.query("select max(stockNum) from spec", new ScalarHandler<>());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }


}
