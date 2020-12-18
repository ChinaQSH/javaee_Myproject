package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 15:00
 * @Version: 1.0
 */

import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.bean.order.VO.OrderGetVO;
import com.nylg.javaee.bean.order.VO.OrderUpdateSpecVO;

import java.util.List;

/**
 *@Description:
 *
 */
public interface OrderDao {
    List<OrderGetVO> ordersByPage(OrderGetBO orderGetBO);

    int getTotal(OrderGetBO orderGetBO);

    order getOrder(int id);

    List<OrderUpdateSpecVO> getSpec(String goods);

    int changOrder(UpdeateOrderBO updeateOrderBO);

    int deleteOrder(int id);

//    OrderCurState getCurstate(int id);
//
//    OrderCurSpec getOrderCurSpec(int id);
}
