package com.nylg.javaee.bean.goods;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 10:42
 * @Version: 1.0
 */

/**
 *@Description: 商品信息表
 *
 */
public class Goods {
    private Integer id;
    private String img;
    private String name;
    private Double price;
    private Integer typeId;
    private Integer stokNum;
    private String description;

    public Goods(Integer id, String img, String name, Double price, Integer typeId, Integer stokNum, String description) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.price = price;
        this.typeId = typeId;
        this.stokNum = stokNum;
        this.description = description;
    }

    public Goods() {
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

    public Integer getStokNum() {
        return stokNum;
    }

    public void setStokNum(Integer stokNum) {
        this.stokNum = stokNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
