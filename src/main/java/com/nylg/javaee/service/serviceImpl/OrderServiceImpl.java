package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:51
 * @Version: 1.0
 */

import com.nylg.javaee.bean.order.*;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.bean.order.VO.*;
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
        return orderDao.deleteOrder(id);
    }

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
