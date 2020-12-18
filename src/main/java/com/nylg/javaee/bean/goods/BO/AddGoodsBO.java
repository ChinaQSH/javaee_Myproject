package com.nylg.javaee.bean.goods.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 15:34
 * @Version: 1.0
 */

import java.util.List;

/**
 *@Description: 添加信息的Bean
 *
 */
public class AddGoodsBO {
    private  String name;
    private Integer typeId;
    private String img;
    private String desc;
   List<SpecListBO> specList;

    public AddGoodsBO(String name, Integer typeId, String img, String desc, List<SpecListBO> specList) {
        this.name = name;
        this.typeId = typeId;
        this.img = img;
        this.desc = desc;
        this.specList = specList;
    }


    public AddGoodsBO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<SpecListBO> getSpecList() {
        return specList;
    }

    public void setSpecList(List<SpecListBO> specList) {
        this.specList = specList;
    }

    @Override
    public String toString() {
        return "AddGoodsBO{" +
                "name='" + name + '\'' +
                ", typeId=" + typeId +
                ", img='" + img + '\'' +
                ", desc='" + desc + '\'' +
                ", specList=" + specList +
                '}';
    }
}
