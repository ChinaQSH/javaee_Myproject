package com.nylg.javaee.bean.noReply.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 22:02
 * @Version: 1.0
 */

/**
 *@Description: 留言提交
 *
 */
public class AskGoodMsg {
    private String token;
    private String msg;
    private Integer goodsId;

    public AskGoodMsg(String token, String msg, Integer goodsId) {
        this.token = token;
        this.msg = msg;
        this.goodsId = goodsId;
    }

    public AskGoodMsg() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

}
