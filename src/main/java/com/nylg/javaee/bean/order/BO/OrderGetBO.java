package com.nylg.javaee.bean.order.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:34
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 获取订单页面的请求参数
 *
 */
public class OrderGetBO {
    private Integer state;
    private Integer currentPage;
    private Integer pagesize;
    private String moneyLimit1;
    private String moneyLimit2;
    private String goods;
    private String address;
    private String name;
    private String id;

    public OrderGetBO(Integer state, Integer currentPage, Integer pagesize, String moneyLimit1, String moneyLimit2, String goods, String address, String name, String id) {
        this.state = state;
        this.currentPage = currentPage;
        this.pagesize = pagesize;
        this.moneyLimit1 = moneyLimit1;
        this.moneyLimit2 = moneyLimit2;
        this.goods = goods;
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public OrderGetBO() {
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }

    public String getMoneyLimit1() {
        return moneyLimit1;
    }

    public void setMoneyLimit1(String moneyLimit1) {
        this.moneyLimit1 = moneyLimit1;
    }

    public String getMoneyLimit2() {
        return moneyLimit2;
    }

    public void setMoneyLimit2(String moneyLimit2) {
        this.moneyLimit2 = moneyLimit2;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "OrderGetBO{" +
                "state=" + state +
                ", currentPage=" + currentPage +
                ", pagesize=" + pagesize +
                ", moneyLimit1='" + moneyLimit1 + '\'' +
                ", moneyLimit2='" + moneyLimit2 + '\'' +
                ", goods='" + goods + '\'' +
                ", address='" + address + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public boolean isNumber() {
        if (StringUtils.isEmpty(this.moneyLimit1)) {
            try {
                if (StringUtils.isEmpty(this.moneyLimit1)) {
                    Double.parseDouble(moneyLimit1);
                }
                if (StringUtils.isEmpty(this.moneyLimit2)) {
                    Double.parseDouble(moneyLimit2);
                }
            } catch (Exception e) {
                return false;
            }

        }
        return true;
    }
}
