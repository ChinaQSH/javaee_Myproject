package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:51
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.Spec;
import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;
import com.nylg.javaee.bean.noReply.BO.SendCommentBO;
import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.*;
import com.nylg.javaee.bean.order.VO.*;
import com.nylg.javaee.bean.user.VO.UserOrderIndexVO;
import com.nylg.javaee.dao.OrderDao;
import com.nylg.javaee.dao.daoImpl.OrderDaoImpl;
import com.nylg.javaee.service.OrderService;

import java.util.ArrayList;
import java.util.List;

/**
 *@Description:
 *
 */
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao=new OrderDaoImpl();
    @Override
    public OrderGetPageVO ordersByPage(OrderGetBO orderGetBO) {
//        查询orders中的数据
        List<OrderGetVO> orderGetVOS=orderDao.ordersByPage(orderGetBO);
//        查询total数据，完成分页
        int count=orderDao.getTotal(orderGetBO);
        OrderGetPageVO orderGetPageVO = new OrderGetPageVO();
        orderGetPageVO.setTotal(count);
        orderGetPageVO.setOrders(orderGetVOS);
        return orderGetPageVO;
    }

    @Override
    public OrderUpdateGetVO order(int id) {
//查询订单字段
        order order=orderDao.getOrder(id);
        String goods = order.getGoods();
//获取spec集合
        List<OrderUpdateSpecVO> orderUpdateSpecVOS=orderDao.getSpec(goods);
//        创建statesList
        ArrayList<OrderUpdateGetstatesVO> orderUpdateGetstatesVOS =getStates();
//        获取curstate
        OrderCurState orderCurState=new OrderCurState(order.getState());
//        orderDao
        OrderCurSpec orderCurSpec=new OrderCurSpec(order.getGoodsDetailId());
        OrderUpdateGetVO orderUpdateGetVO = new OrderUpdateGetVO(order.getId(), order.getAmount(), order.getNum(), order.getGoodsDetailId(),
                order.getState(), order.getGoods(), orderUpdateSpecVOS, orderUpdateGetstatesVOS, orderCurState,
                orderCurSpec);
        System.out.println(orderUpdateGetVO);
        return orderUpdateGetVO;
    }

    @Override
    public int changOrder(UpdeateOrderBO updeateOrderBO) {
        return orderDao.changOrder(updeateOrderBO);
    }

    @Override
    public int deleteOrder(int id) {
        //        查找订单中几单商品
        Object []num=orderDao.getNumber(id);
        orderDao.updateSpecNum(num);
        return orderDao.deleteOrder(id);
    }

    @Override
    public int addOrder(OrderAddIndex orderAddIndex) {
//        先获取User信息
        UserOrderIndexVO userOrderIndexVO=orderDao.getUserInfo(orderAddIndex.getToken());
//        获取规格信息
        Spec spec=orderDao.getSpecs(orderAddIndex.getGoodsDetailId());
//        获取商品名称
        String name=orderDao.getGoodName(spec.getGoodId());
//        Integer num = spec.getStockNum()-orderAddIndex.getNum();
//        spec.setStockNum(num);
        if (spec.getStockNum()<orderAddIndex.getNum()){
            return 404;
        }else {
            orderDao.insertOrder(userOrderIndexVO,spec,name,orderAddIndex);
        }
       return 200;
    }

    @Override
    public List<OrderInfoIndex> getOrderByState(int state, String token) {

        if (state==-1){

            return orderDao.getOrderByStates(state,token);
        }

//        个人中心显示
        return orderDao.getOrderByState(state,token);
    }

    @Override
    public void settleAccounts(OrderCartListBO orderCartListBO) {
        List<CartList> cartList = orderCartListBO.getCartList();
        for (CartList list : cartList) {
//            修改order信息
            orderDao.updateOrder(list);
        }
    }

    @Override
    public void pay(int id) {
        orderDao.pay(id);
    }

    @Override
    public void confirmReceive(int id) {
        orderDao.confirmReceive(id);
    }

    @Override
    public void sendComment(SendCommentBO sendCommentBO) {
//        获取userId，specId
        int userId = orderDao.getUserId(sendCommentBO.getToken());
        orderDao.sendComment(sendCommentBO,userId);

    }

//    @Override
//    public int deleteOrderIndex(int id) {
//
//        orderDao.deleteOrder(id);
////        查找
//    }

    private ArrayList<OrderUpdateGetstatesVO> getStates() {
        ArrayList<OrderUpdateGetstatesVO> orderUpdateGetstatesVOS = new ArrayList<>();
        OrderUpdateGetstatesVO element1 = new OrderUpdateGetstatesVO(0, "未付款");
        OrderUpdateGetstatesVO element2 = new OrderUpdateGetstatesVO(1, "未发货");
        OrderUpdateGetstatesVO element3 = new OrderUpdateGetstatesVO(2, "已发货");
        OrderUpdateGetstatesVO element4 = new OrderUpdateGetstatesVO(3, "已完成订单");
        orderUpdateGetstatesVOS.add(element1);
        orderUpdateGetstatesVOS.add(element2);
        orderUpdateGetstatesVOS.add(element3);
        orderUpdateGetstatesVOS.add(element4);
        return orderUpdateGetstatesVOS;

    }
}
