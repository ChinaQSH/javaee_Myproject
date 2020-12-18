package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:14
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.*;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.GoodsNameVO;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.bean.noReply.VO.ReplyMagVO;
import com.nylg.javaee.bean.noReply.VO.UserNameVO;
import com.nylg.javaee.dao.NoReplyDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static java.time.OffsetTime.now;

/**
 *@Description:
 *
 */
public class NoReplyDaoImpl  implements NoReplyDao {


//    @Override
//    public List<NoReply> getReply() {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        List<NoReply> query = null;
//        try {
//            query = queryRunner.query("select id,userId,goodsId,content,state,createtime from reply", new BeanListHandler<NoReply>(NoReply.class));
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
//
//    @Override
//    public GoodsNameVO getGoodsName(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        GoodsNameVO query = null;
//        try {
//            query=queryRunner.query("select name from goods where id=?",new BeanHandler<>(GoodsNameVO.class),id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
//
//    @Override
//    public UserNameVO getUserName(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        UserNameVO query = null;
//        try {
//            query=queryRunner.query("select nickname as name from user where id=?",new BeanHandler<>(UserNameVO.class),id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }


    @Override
    public List<NoReplyMaGVO> getNOReplys() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<NoReplyMaGVO> query = null;
        try {
            query = queryRunner.query("select r.id,r.userId,r.goodsId,r.content,r.state,r.createtime,g.name as goodsname,u.nickname as name from reply r,goods g,user u where r.userId=u.id and r.goodsId=g.id", new BeanListHandler<NoReplyMaGVO>(NoReplyMaGVO.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    /**
     * @Date:2020/12/17 9:03
     * @Param replyBO:
     * @return: int
     * @Author:QSH
     * @Description: 回复信息
     */
    @Override
    public int reply(ReplyBO replyBO) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            int STATE_CODE=0;
//            queryRunner.update("insert into reply (replyContent) values (?) where id=?",replyBO.getContent(),replyBO.getId());
            queryRunner.update("update reply set state=?,replyContent=? where id=?",STATE_CODE,replyBO.getContent(),replyBO.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }

    @Override
    public List<ReplyMagVO> getReplys() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<ReplyMagVO> query = null;
        try {
            query = queryRunner.query("select r.id,r.userId,r.goodsId,r.content,r.replyContent,r.state,r.createtime,g.name as goodsname,u.nickname as name from reply r,goods g,user u where r.userId=u.id and r.goodsId=g.id", new BeanListHandler<ReplyMagVO>(ReplyMagVO.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

}
