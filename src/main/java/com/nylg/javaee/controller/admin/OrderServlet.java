package com.nylg.javaee.controller.admin;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.order.BO.OrderGetBO;
import com.nylg.javaee.bean.order.VO.OrderGetPageVO;
import com.nylg.javaee.bean.order.VO.OrderUpdateGetVO;
import com.nylg.javaee.bean.order.BO.UpdeateOrderBO;
import com.nylg.javaee.service.OrderService;
import com.nylg.javaee.service.serviceImpl.OrderServiceImpl;
import com.nylg.javaee.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:25
 * @Version: 1.0
 */
@WebServlet("/api/admin/order/*")
public class OrderServlet extends HttpServlet {
    private Gson gson=new Gson();
    private OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/order/", "");
        if ("ordersByPage".equals(replaceStr)){
            ordersByPage(request,response);
        }
        if ("changeOrder".equals(replaceStr)){
            changeOrder(request,response);
        }
    }

    private void changeOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        UpdeateOrderBO updeateOrderBO = gson.fromJson(requestParameter, UpdeateOrderBO.class);
        int code=orderService.changOrder(updeateOrderBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
    }

    private void ordersByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        OrderGetBO orderGetBO = gson.fromJson(requestParameter, OrderGetBO.class);
        System.out.println(orderGetBO);
//        if(!orderGetBO.isNumber()){
//            response.getWriter().println(gson.toJson(Result.error("参数不正确")));
//            return;
//        }

//首先校验moneyLimit
        OrderGetPageVO orderGetPageVO = orderService.ordersByPage(orderGetBO);
//        OrderGetPageVO orderGetPageVO=orderService.ordersByPage(orderGetBO);
        System.out.println(orderGetPageVO);
        response.getWriter().println(gson.toJson(Result.ok(orderGetPageVO)));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/order/", "");
        if ("order".equals(replaceStr)){
            order(request,response);
        }
        if("deleteOrder".equals(replaceStr)){
            deleteOrder(request,response);
        }
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        int code=orderService.deleteOrder(id);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }

    }

    private void order(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderUpdateGetVO orderUpdateGetVO=orderService.order(id);
        response.getWriter().println(gson.toJson(Result.ok(orderUpdateGetVO)));

    }
}
