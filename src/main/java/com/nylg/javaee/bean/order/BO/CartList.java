package com.nylg.javaee.bean.order.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 18:55
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class CartList {
    private Integer id;
    private Integer goodsNum;
    private Double amount;

    public CartList(Integer id, Integer goodsNum, Double amount) {
        this.id = id;
        this.goodsNum = goodsNum;
        this.amount = amount;
    }

    public CartList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
