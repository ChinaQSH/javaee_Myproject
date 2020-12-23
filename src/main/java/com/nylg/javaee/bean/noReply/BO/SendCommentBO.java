package com.nylg.javaee.bean.noReply.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 20:10
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class SendCommentBO {
    private String token;
    private Integer orderId;
    private Integer goodsId;
    private Integer goodsDetailId;
    private String content;
    private Integer score;

    public SendCommentBO(String token, Integer orderId, Integer goodsId, Integer goodsDetailId, String content, Integer score) {
        this.token = token;
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.goodsDetailId = goodsDetailId;
        this.content = content;
        this.score = score;
    }

    public SendCommentBO() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
