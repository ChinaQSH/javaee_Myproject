package com.nylg.javaee.service;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:50
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;
import com.nylg.javaee.bean.noReply.BO.SendCommentBO;
import com.nylg.javaee.bean.order.BO.OrderAddIndex;
import com.nylg.javaee.bean.order.BO.OrderCartListBO;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.VO.OrderGetPageVO;
import com.nylg.javaee.bean.order.VO.OrderInfoIndex;
import com.nylg.javaee.bean.order.VO.OrderUpdateGetVO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;

import java.util.List;

/**
 *@Description:
 *
 */
public interface OrderService {
    OrderGetPageVO ordersByPage(OrderGetBO orderGetBO);

    OrderUpdateGetVO order(int id);

    int changOrder(UpdeateOrderBO updeateOrderBO);

    int deleteOrder(int id);
/**
 * @Date:2020/12/19 13:08
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 添加订单
 */
    int addOrder(OrderAddIndex orderAddIndex);

    List<OrderInfoIndex> getOrderByState(int state, String token);


    void settleAccounts(OrderCartListBO orderCartListBO);

    void pay(int id);

    void confirmReceive(int id);

    void sendComment(SendCommentBO sendCommentBO);
}
