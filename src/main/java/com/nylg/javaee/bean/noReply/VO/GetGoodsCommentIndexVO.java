package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 17:30
 * @Version: 1.0
 */

import java.util.List;

/**
 *@Description:
 *
 */
//好评的信息
public class GetGoodsCommentIndexVO {
    private List<CommentListVO> commentList;
    private Double rate;

    public GetGoodsCommentIndexVO(List<CommentListVO> commentList, Double rate) {
        this.commentList = commentList;
        this.rate = rate;
    }

    public GetGoodsCommentIndexVO() {
    }

    public List<CommentListVO> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<CommentListVO> commentList) {
        this.commentList = commentList;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }
}
