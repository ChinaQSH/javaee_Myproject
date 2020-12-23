package com.nylg.javaee.controller.index;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;
import com.nylg.javaee.bean.noReply.BO.SendCommentBO;
import com.nylg.javaee.bean.order.BO.OrderAddIndex;
import com.nylg.javaee.bean.order.BO.OrderCartListBO;
import com.nylg.javaee.bean.order.VO.OrderInfoIndex;
import com.nylg.javaee.service.OrderService;
import com.nylg.javaee.service.serviceImpl.OrderServiceImpl;
import com.nylg.javaee.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 15:13
 * @Version: 1.0
 */
@WebServlet("/api/mall/order/*")
public class OrderServlet extends HttpServlet {
    private Gson gson=new Gson();
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/order/", "");
        if ("addOrder".equals(replaceStr)){
            addOrder(request,response);
        }
        if ("settleAccounts".equals(replaceStr)){
            settleAccounts(request,response);
        }
        if ("sendComment".equals(replaceStr)){
            sendComment(request,response);
        }
    }
    /**
     * @Date:2020/12/19 20:08
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 评价
     */
    private void sendComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        SendCommentBO sendCommentBO = gson.fromJson(requestParameter, SendCommentBO.class);
        orderService.sendComment(sendCommentBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void settleAccounts(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获得请求
        String requestParameter = HttpUtil.getRequestParameter(request);
        OrderCartListBO orderCartListBO = gson.fromJson(requestParameter, OrderCartListBO.class);
//        System.out.println(orderCartListBO);
        orderService.settleAccounts(orderCartListBO);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        String requestParameter = HttpUtil.getRequestParameter(request);
        OrderAddIndex orderAddIndex = gson.fromJson(requestParameter, OrderAddIndex.class);
        int code=orderService.addOrder(orderAddIndex);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
        if (code==404){
            response.getWriter().println(gson.toJson(Result.error("该商品库存不足")));
        }


    }
//个人主页
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/order/", "");
        if ("getOrderByState".equals(replaceStr)){
            getOrderByState(request,response);
        }
        if ("deleteOrder".equals(replaceStr)){
            deleteOrder(request,response);
        }
        if ("pay".equals(replaceStr)){
            pay(request,response);
        }
        if ("confirmReceive".equals(replaceStr)){
            confirmReceive(request,response);
        }
    }
/**
 * @Date:2020/12/19 20:02
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 确认收货
 */
    private void confirmReceive(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.confirmReceive(id);
        response.getWriter().println(gson.toJson(Result.ok()));
    }

    private void pay(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.pay(id);
        response.getWriter().println(gson.toJson(Result.ok()));

    }

    /**
     * @Date:2020/12/19 17:21
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 删除订单
     */
    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        int i = orderService.deleteOrder(id);
        if (i==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }

    }

    private void getOrderByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        int state = Integer.parseInt(request.getParameter("state"));
        String token = request.getParameter("token");
        List<OrderInfoIndex> orderInfoIndices=orderService.getOrderByState(state,token);
        System.out.println(orderInfoIndices);
        response.getWriter().println(gson.toJson(Result.ok(orderInfoIndices)));
    }


}
