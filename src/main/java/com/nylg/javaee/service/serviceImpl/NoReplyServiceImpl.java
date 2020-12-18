package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 19:57
 * @Version: 1.0
 */

import com.nylg.javaee.bean.noReply.*;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.GoodsNameVO;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.bean.noReply.VO.ReplyMagVO;
import com.nylg.javaee.bean.noReply.VO.UserNameVO;
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
}
