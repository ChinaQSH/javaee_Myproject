package com.nylg.javaee.controller.index;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.service.AdminService;
import com.nylg.javaee.service.GoodsService;
import com.nylg.javaee.service.serviceImpl.AdminServiceImpl;
import com.nylg.javaee.service.serviceImpl.GoodServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 15:13
 * @Version: 1.0
 */
@WebServlet("/api/mall/index/*")
public class IndexServlet extends HttpServlet {
    private Gson gson=new Gson();
    private GoodsService goodsService=new GoodServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/index/", "");
        if ("getType".equals(replaceStr)){
            getType(request,response);
        }
        if ("getGoodsByType".equals(replaceStr)){
            getGoodsByType(request,response);
        }
    }

    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        List<GetGoodsVO> goodsByType = goodsService.getGoodsByType(typeId);
        System.out.println(goodsByType);
        response.getWriter().println(gson.toJson(Result.ok(goodsByType)));
    }

    //获取商品分类
    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<GoodTypeVO> type = goodsService.getType();
        System.out.println(type);
        response.getWriter().println(gson.toJson(Result.ok(type)));
    }
}
