package com.nylg.javaee.bean.goods;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 19:06
 * @Version: 1.0
 */

/**
 *@Description: 商品规格
 *
 */
public class Spec {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;
    private Integer goodId;

    public Spec(Integer id, String specName, Integer stockNum, Double unitPrice, Integer goodId) {
        this.id = id;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
        this.goodId = goodId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public Integer getStockNum() {
        return stockNum;
    }

    public void setStockNum(Integer stockNum) {
        this.stockNum = stockNum;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Spec() {
    }
}
