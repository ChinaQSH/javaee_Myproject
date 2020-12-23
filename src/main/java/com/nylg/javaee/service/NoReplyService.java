package com.nylg.javaee.service;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 19:56
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.BO.AskGoodMsg;
import com.nylg.javaee.bean.noReply.VO.GetGoodsCommentIndexVO;
import com.nylg.javaee.bean.noReply.VO.GetReplyMsgIndex;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.ReplyMagVO;

import java.util.List;

/**
 *@Description:
 *
 */
public interface NoReplyService {
    List<NoReplyMaGVO> noReplyMsg();

    int reply(ReplyBO replyBO);

    List<ReplyMagVO> repliedMsg();

    List<GetReplyMsgIndex> getGoodsMsg(int id);
/**
 * @Date:2020/12/18 17:39
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 好评信息
 */
    GetGoodsCommentIndexVO getGoodsComment(int goodsId);

    void askGoodMsg(AskGoodMsg askGoodMsg);

}
