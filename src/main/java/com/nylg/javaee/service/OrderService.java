package com.nylg.javaee.service;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:50
 * @Version: 1.0
 */

import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.VO.OrderGetPageVO;
import com.nylg.javaee.bean.order.VO.OrderUpdateGetVO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;

/**
 *@Description:
 *
 */
public interface OrderService {
    OrderGetPageVO ordersByPage(OrderGetBO orderGetBO);

    OrderUpdateGetVO order(int id);

    int changOrder(UpdeateOrderBO updeateOrderBO);

    int deleteOrder(int id);
}
