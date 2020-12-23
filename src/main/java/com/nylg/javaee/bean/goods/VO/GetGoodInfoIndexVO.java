package com.nylg.javaee.bean.goods.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 16:20
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.BO.UpdateSpecListBO;

import java.util.List;

/**
 *@Description: 获取前台的商品数据
 *
 */
public class GetGoodInfoIndexVO {
    private String img;
    private String name;
    private String desc;
    private  Integer typeId;
    private List<UpdateSpecListBO> specs;
    private Double unitPrice;

    public GetGoodInfoIndexVO(String img, String name, String desc, Integer typeId, List<UpdateSpecListBO> specs, Double unitPrice) {
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.typeId = typeId;
        this.specs = specs;
        this.unitPrice = unitPrice;
    }

    public GetGoodInfoIndexVO() {
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public List<UpdateSpecListBO> getSpecs() {
        return specs;
    }

    public void setSpecs(List<UpdateSpecListBO> specs) {
        this.specs = specs;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
