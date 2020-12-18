package com.nylg.javaee.bean.order;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:14
 * @Version: 1.0
 */

/**
 *@Description: 订单表
 *
 */
public class order {
    private Integer id;
    private Double amount;
    private Integer num;
    private Integer goodsDetailId;
    private Integer state;
    private String goods;

    public order(Integer id, Double amount, Integer num, Integer goodsDetailId, Integer state, String goods) {
        this.id = id;
        this.amount = amount;
        this.num = num;
        this.goodsDetailId = goodsDetailId;
        this.state = state;
        this.goods = goods;
    }

    public order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }
}
