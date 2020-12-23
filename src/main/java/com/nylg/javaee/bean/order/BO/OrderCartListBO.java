package com.nylg.javaee.bean.order.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 18:53
 * @Version: 1.0
 */

import java.util.List;

/**
 *@Description: 购物车订单
 *
 */
public class OrderCartListBO {
    private List<CartList> cartList;

    public void setCartList(List<CartList> cartList) {
        this.cartList = cartList;
    }

    public List<CartList> getCartList() {
        return cartList;
    }
}
