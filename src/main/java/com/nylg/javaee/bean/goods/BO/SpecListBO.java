package com.nylg.javaee.bean.goods.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 15:37
 * @Version: 1.0
 */

/**
 *@Description: 添加商品的规格信息
 *
 */
public class SpecListBO {
    private String specName;
    private Integer stockNum;
    private Double unitPrice;

    public SpecListBO(String specName, Integer stockNum, Double unitPrice) {
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }

    public SpecListBO() {
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

    @Override
    public String toString() {
        return "SpecListBO{" +
                "specName='" + specName + '\'' +
                ", stockNum=" + stockNum +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
