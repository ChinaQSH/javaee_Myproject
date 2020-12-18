package com.nylg.javaee.bean.goods.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 09:43
 * @Version: 1.0
 */

/**
 *@Description: 添加spec请求Bean
 *
 */
public class AddSpecBO {
    private String goodsId;
    private String specName;
    private String stockNum;
    private String unitPrice;
    public AddSpecBO(String goodsId, String specName, String stockNum, String unitPrice) {
        this.goodsId = goodsId;
        this.specName = specName;
        this.stockNum = stockNum;
        this.unitPrice = unitPrice;
    }

    public AddSpecBO() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getStockNum() {
        return stockNum;
    }

    public void setStockNum(String stockNum) {
        this.stockNum = stockNum;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "AddSpecBO{" +
                "goodsId='" + goodsId + '\'' +
                ", speName='" + specName + '\'' +
                ", stockNum='" + stockNum + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                '}';
    }
}
