package com.nylg.javaee.bean.order.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 19:48
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class UpdeateOrderBO {
    private String id;
    private Integer state;
    private Integer spec;
    private String num;

    public UpdeateOrderBO(String id, Integer state, Integer spec, String num) {
        this.id = id;
        this.state = state;
        this.spec = spec;
        this.num = num;
    }

    public UpdeateOrderBO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSpec() {
        return spec;
    }

    public void setSpec(Integer spec) {
        this.spec = spec;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
