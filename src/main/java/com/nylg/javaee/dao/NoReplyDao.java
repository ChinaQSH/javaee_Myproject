package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:12
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.*;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.GoodsNameVO;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.bean.noReply.VO.ReplyMagVO;
import com.nylg.javaee.bean.noReply.VO.UserNameVO;

import java.util.List;

/**
 *@Description:
 *
 */
public interface NoReplyDao {


//    List<NoReply> getReply();
//
//    GoodsNameVO getGoodsName(int id);
//
//    UserNameVO getUserName(int id);

    int reply(ReplyBO replyBO);

    List<ReplyMagVO> getReplys();

    List<NoReplyMaGVO> getNOReplys();
}
