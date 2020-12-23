package com.nylg.javaee.bean.goods.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 08:54
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class GetSearchGoodsVO {
    private Integer id;
    private String img;
    private String name;
    private Double price;
    private Integer typeId;

    public GetSearchGoodsVO(Integer id, String img, String name, Double price, Integer typeId) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
    }

    public GetSearchGoodsVO() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
}
