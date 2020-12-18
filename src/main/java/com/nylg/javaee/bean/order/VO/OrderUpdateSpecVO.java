package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 17:13
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class OrderUpdateSpecVO {
    private Integer id;
    private String specName;
    private  Integer unitPrice;

    public OrderUpdateSpecVO(Integer id, String specName, Integer unitPrice) {
        this.id = id;
        this.specName = specName;
        this.unitPrice = unitPrice;
    }

    public OrderUpdateSpecVO() {
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

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }
}
