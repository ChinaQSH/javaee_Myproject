package com.nylg.javaee.bean.order.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 13:01
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class OrderAddIndex {

    private String token;
    private Integer goodsDetailId;
    private Integer num;
    private Integer state;
    private Double amount;

    public OrderAddIndex(String token, Integer goodsDetailId, Integer num, Integer state, Double amount) {
        this.token = token;
        this.goodsDetailId = goodsDetailId;
        this.num = num;
        this.state = state;
        this.amount = amount;
    }

    public OrderAddIndex() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
