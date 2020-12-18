package com.nylg.javaee.bean.goods.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 19:46
 * @Version: 1.0
 */

/**
 *@Description: 修改的回显响应Bean
 *
 */
public class GetGoodInfoVO {
//    id,img,name,description as desc,typeId,price as unitPrice
    private Integer id;
    private String img;
    private String name;
    private String desc;
    private  Integer typeId;
    private Double unitPrice;

    public GetGoodInfoVO(Integer id, String img, String name, String desc, Integer typeId, Double unitPrice) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.desc = desc;
        this.typeId = typeId;
        this.unitPrice = unitPrice;
    }

    public GetGoodInfoVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
