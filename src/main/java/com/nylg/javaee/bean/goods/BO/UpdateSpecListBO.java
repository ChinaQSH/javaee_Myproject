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
public class UpdateSpecListBO {
    private Integer id;
    private String specName;
    private Integer stockNum;
    private Double unitPrice;

    public UpdateSpecListBO(Integer id, String specName, Integer stockNum, Double unitPrice) {
        this.id = id;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }

    public UpdateSpecListBO() {
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

}
