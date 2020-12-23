package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 19:57
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.*;
import com.nylg.javaee.bean.noReply.BO.AskGoodMsg;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.*;
import com.nylg.javaee.dao.NoReplyDao;
import com.nylg.javaee.dao.daoImpl.NoReplyDaoImpl;
import com.nylg.javaee.service.NoReplyService;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description:
 *
 */
public class NoReplyServiceImpl implements NoReplyService {
private NoReplyDao noReplyDao=new NoReplyDaoImpl();
    @Override
    public List<NoReplyMaGVO> noReplyMsg() {
//        List<NoReplyMaGVO> noReplyMaGVOS=new ArrayList<>();
//
////        首先拿到数据
//        List<NoReply> noReplies=noReplyDao.getReply();
//        System.out.println(noReplies);
////获取goods信息
////        查询goodId和UserId
//        for (int i=0;i<noReplies.size();i++) {
//            NoReplyMaGVO noReplyMaGVO = new NoReplyMaGVO();
//            noReplyMaGVO.setId(noReplies.get(i).getId());
//            noReplyMaGVO.setUserId(noReplies.get(i).getUserId());
//            noReplyMaGVO.setGoodsId(noReplies.get(i).getGoodsId());
//            noReplyMaGVO.setContent(noReplies.get(i).getContent());
//            noReplyMaGVO.setState(noReplies.get(i).getState());
//            noReplyMaGVO.setCreatetime(noReplies.get(i).getCreatetime());
//            GoodsNameVO goodsNameVO= noReplyDao.getGoodsName(noReplies.get(i).getGoodsId());
//            noReplyMaGVO.setGoods(goodsNameVO);
//            UserNameVO userNameVO= noReplyDao.getUserName(noReplies.get(i).getUserId());
//            noReplyMaGVO.setUser(userNameVO);
//            noReplyMaGVOS.add(noReplyMaGVO);
//        }
//        System.out.println(noReplyMaGVOS);
//return noReplyMaGVOS;

        return noReplyDao.getNOReplys();

    }

    @Override
    public int reply(ReplyBO replyBO) {
        return noReplyDao.reply(replyBO);
    }

    @Override
    public List<ReplyMagVO> repliedMsg() {

//        查询字段
        return noReplyDao.getReplys();
    }

    @Override
    public List<GetReplyMsgIndex> getGoodsMsg(int id) {
//        获取字段
//        GetReplyMsg getReplyMsg=noReplyDao.getGoodsMsgF(id);
//        Reply reply=noReplyDao.getReply(id);
        return noReplyDao.getGoodsMsg(id);

    }

    @Override
    public GetGoodsCommentIndexVO getGoodsComment(int goodsId) {

//        获取List
        List<CommentListVO> commentListVOS=noReplyDao.getComment(goodsId);
        ArrayList<Integer> integers = new ArrayList<>();

//        获取所有的 score
        for (CommentListVO commentListVO : commentListVOS) {
            integers.add(commentListVO.getScore());
        }
        int num=integers.size();
        int sum=0;
        for (Integer integer : integers) {
            sum=sum+integer;
        }
        if (num==0){
            GetGoodsCommentIndexVO getGoodsCommentIndexVO = new GetGoodsCommentIndexVO(commentListVOS,0.0);
            return getGoodsCommentIndexVO;
        }
        Double rate= Double.valueOf(sum/num);
        GetGoodsCommentIndexVO getGoodsCommentIndexVO = new GetGoodsCommentIndexVO(commentListVOS,rate);
        return getGoodsCommentIndexVO;
    }

    @Override
    public void askGoodMsg(AskGoodMsg askGoodMsg) {
//        获取userId
        UserIdVO userIdVO=noReplyDao.getUserId(askGoodMsg.getToken());
//        获取specID

//添加数据
noReplyDao.InsertReply(userIdVO.getId(),askGoodMsg);
    }
}
