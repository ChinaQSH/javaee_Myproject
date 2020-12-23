package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:14
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.*;
import com.nylg.javaee.bean.noReply.BO.AskGoodMsg;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.*;
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
            query = queryRunner.query("select r.id,r.userId,r.goodsId,r.content,r.state,r.createtime,g.name as goodsname,u.nickname as name from reply r,goods g,user u where r.userId=u.id and r.goodsId=g.id,state=1", new BeanListHandler<NoReplyMaGVO>(NoReplyMaGVO.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public List<GetReplyMsgIndex> getGoodsMsg(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<GetReplyMsgIndex> query = null;
        try {
            query = queryRunner.query("select r.id,r.content,u.nickname as asker,r.createtime as time,r.replyContent,r.replytime from reply r,user u where u.id=r.userId and r.goodsId=?", new BeanListHandler<>(GetReplyMsgIndex.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
//    @Override
//    public GetReplyMsg getGoodsMsgF(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        GetReplyMsg query = null;
//        try {
//            query = queryRunner.query("select r.id,r.content,u.nickname as asker,r.createtime as time from reply r,user u where r.goodsId=?", new BeanHandler<>(GetReplyMsg.class),id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//    }
//
//    @Override
//    public Reply getReply(int id) {
//        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
//        Reply query = null;
//        try {
//            query = queryRunner.query("select replyContent from reply where goodsId=?", new BeanHandler<>(Reply.class),id);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return query;
//
//    }

    @Override
    public List<CommentListVO> getComment(int goodsId) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<CommentListVO> query = null;
        try {
            query = queryRunner.query("select u.nickname,r.score,r.id,s.specName,r.content as comment,r.createtime as time,r.userId from reply r,spec s,user u where r.goodsId=? and u.id=r.userId and s.id=r.specId;", new BeanListHandler<>(CommentListVO.class), goodsId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public UserIdVO getUserId(String token) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        UserIdVO query = null;
        try {
            query = queryRunner.query("select id from user where nickname=?", new BeanHandler<>(UserIdVO.class), token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void InsertReply(Integer id, AskGoodMsg askGoodMsg) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into reply values (null,?,?,?,1,now(),?,?,?,?)",id,askGoodMsg.getGoodsId(),
                    askGoodMsg.getMsg(),null,0,0,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
            queryRunner.update("update reply set state=?,replyContent=?,replytime=now() where id=?",STATE_CODE,replyBO.getContent(),replyBO.getId());
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
