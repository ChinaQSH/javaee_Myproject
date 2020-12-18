package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:53
 * @Version: 1.0
 */

import java.util.List;

/**
 *@Description:
 *
 */
public class OrderGetPageVO {
    private Integer total;
    private List<OrderGetVO> orders;

    public OrderGetPageVO(Integer total, List<OrderGetVO> orders) {
        this.total = total;
        this.orders = orders;
    }

    public OrderGetPageVO() {
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<OrderGetVO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderGetVO> orders) {
        this.orders = orders;
    }
}
