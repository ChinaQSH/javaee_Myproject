package com.nylg.javaee.bean.goods.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:23
 * @Version: 1.0
 */

/**
 *@Description: 商品分类返回Bean
 *
 */
public class GoodTypeVO {
    private Integer id;
    private String name;

    public GoodTypeVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public GoodTypeVO() {
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
}
