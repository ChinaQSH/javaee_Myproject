package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 15:00
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.Spec;
import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;
import com.nylg.javaee.bean.noReply.BO.SendCommentBO;
import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.CartList;
import com.nylg.javaee.bean.order.BO.OrderAddIndex;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.bean.order.VO.OrderGetVO;
import com.nylg.javaee.bean.order.VO.OrderInfoIndex;
import com.nylg.javaee.bean.order.VO.OrderUpdateSpecVO;
import com.nylg.javaee.bean.user.VO.UserOrderIndexVO;

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

    UserOrderIndexVO getUserInfo(String token);

    Spec getSpecs(Integer goodsDetailId);

    String getGoodName(Integer goodId);

    void insertOrder(UserOrderIndexVO userOrderIndexVO, Spec spec, String name, OrderAddIndex orderAddIndex);

    List<OrderInfoIndex> getOrderByState(int state, String token);

    Object[] getNumber(int id);

    void updateSpecNum(Object []num);

    void updateOrder(CartList list);

    List<OrderInfoIndex> getOrderByStates(int state, String token);

    void pay(int id);

    void confirmReceive(int id);

    void sendComment(SendCommentBO sendCommentBO,int userId);

   int getUserId(String token);


//    OrderCurState getCurstate(int id);
//
//    OrderCurSpec getOrderCurSpec(int id);
}
