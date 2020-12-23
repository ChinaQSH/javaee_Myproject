package com.nylg.javaee.controller.index;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.goods.VO.GetGoodInfoIndexVO;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GetSearchGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.bean.noReply.BO.AskGoodMsg;
import com.nylg.javaee.bean.noReply.VO.GetGoodsCommentIndexVO;
import com.nylg.javaee.bean.noReply.VO.GetReplyMsgIndex;
import com.nylg.javaee.service.GoodsService;
import com.nylg.javaee.service.NoReplyService;
import com.nylg.javaee.service.serviceImpl.GoodServiceImpl;
import com.nylg.javaee.service.serviceImpl.NoReplyServiceImpl;
import com.nylg.javaee.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 15:13
 * @Version: 1.0
 */
@WebServlet("/api/mall/goods/*")
public class GoodsServlet extends HttpServlet {
    private Gson gson=new Gson();
    private GoodsService goodsService=new GoodServiceImpl();
    private NoReplyService noReplyService=new NoReplyServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/goods/", "");
        if ("askGoodsMsg".equals(replaceStr)){
            askGoodsMsg(request,response);
        }
    }

    private void askGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        AskGoodMsg askGoodMsg = gson.fromJson(requestParameter, AskGoodMsg.class);
        noReplyService.askGoodMsg(askGoodMsg);
        response.getWriter().println(gson.toJson(Result.ok()));

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/goods/", "");
        if ("getGoodsByType".equals(replaceStr)){
            getGoodsByType(request,response);
        }
        if ("getGoodsInfo".equals(replaceStr)){
            getGoodsInfo(request,response);
        }
        if ("getGoodsMsg".equals(replaceStr)){
            getGoodsMsg(request,response);
        }
        if ("getGoodsComment".equals(replaceStr)){
            getGoodsComment(request,response);
        }
        if("searchGoods".equals(replaceStr)){
            searchGoods(request,response);
        }
    }

    private void searchGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       获取请求参数
        String keyword = request.getParameter("keyword");
        List<GetSearchGoodsVO> getSearchGoodsVOS=goodsService.searchGoods(keyword);
        response.getWriter().println(gson.toJson(Result.ok(getSearchGoodsVOS)));
    }

    //获取好评信息
    private void getGoodsComment(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取参数
        int goodsId = Integer.parseInt(request.getParameter("goodsId"));
        GetGoodsCommentIndexVO getGoodsCommentIndexVO=noReplyService.getGoodsComment(goodsId);
        response.getWriter().println(gson.toJson(Result.ok(getGoodsCommentIndexVO)));
    }

    private void getGoodsMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求的参数
        int id = Integer.parseInt(request.getParameter("id"));
        List<GetReplyMsgIndex> getReplyMsgIndex=noReplyService.getGoodsMsg(id);
        System.out.println(getReplyMsgIndex);
        response.getWriter().println(gson.toJson(Result.ok(getReplyMsgIndex)));
    }

    //查看商品的详细页面
    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        int  id = Integer.parseInt(request.getParameter("id"));
       GetGoodInfoIndexVO getGoodInfoIndexVO= goodsService.getGoodsInfoIndex(id);
       response.getWriter().println(gson.toJson(Result.ok(getGoodInfoIndexVO)));
    }

    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        List<GetGoodsVO> goodsByType = goodsService.getGoodsByType(typeId);
        System.out.println(goodsByType);
        response.getWriter().println(gson.toJson(Result.ok(goodsByType)));
    }


}
