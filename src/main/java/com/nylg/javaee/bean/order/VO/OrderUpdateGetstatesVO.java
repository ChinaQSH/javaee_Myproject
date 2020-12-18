package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 17:18
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class OrderUpdateGetstatesVO {
    private Integer id;
    private String name;

    public OrderUpdateGetstatesVO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public OrderUpdateGetstatesVO() {
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
