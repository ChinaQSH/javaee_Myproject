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
public class UpdateGoodsBO {
    private Integer id;
    private  String name;
    private Integer typeId;
    private String img;
    private String desc;
   List<UpdateSpecListBO> specList;

    public UpdateGoodsBO(Integer id, String name, Integer typeId, String img, String desc, List<UpdateSpecListBO> specList) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.img = img;
        this.desc = desc;
        this.specList = specList;
    }

    public List<UpdateSpecListBO> getSpecList() {
        return specList;
    }

    public void setSpecList(List<UpdateSpecListBO> specList) {
        this.specList = specList;
    }

    public UpdateGoodsBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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





}
