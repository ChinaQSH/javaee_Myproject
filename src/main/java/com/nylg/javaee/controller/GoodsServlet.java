package com.nylg.javaee.controller;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.goods.BO.*;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.bean.noReply.BO.ReplyBO;
import com.nylg.javaee.bean.noReply.VO.ReplyMagVO;
import com.nylg.javaee.service.GoodsService;
import com.nylg.javaee.service.NoReplyService;
import com.nylg.javaee.service.serviceImpl.GoodServiceImpl;
import com.nylg.javaee.service.serviceImpl.NoReplyServiceImpl;
import com.nylg.javaee.util.FileUploadUtils;
import com.nylg.javaee.util.HttpUtil;

import javax.servlet.ServletContext;
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
 * @create: 2020/12/14 22:54
 * @Version: 1.0
 */
@WebServlet("/api/admin/goods/*")
public class GoodsServlet extends HttpServlet {
    private GoodsService goodsService=new GoodServiceImpl();
    private NoReplyService noReplyService=new NoReplyServiceImpl();
    private Gson gson=new Gson();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/goods/", "");
        if("addType".equals(replaceStr)){
            addType(request,response);
        }
        if ("imgUpload".equals(replaceStr)){
            imgUpload(request,response);
        }
        if ("addGoods".equals(replaceStr)){
            addGoods(request,response);
        }
        if("updateGoods".equals(replaceStr)){
            updateGoods(request,response);
        }
        if("addSpec".equals(replaceStr)){
            addSpec(request,response);
        }
        if ("deleteSpec".equals(replaceStr)){
            deleteSpec(request,response);
        }
        if ("reply".equals(replaceStr)){
            reply(request,response);
        }

    }

    private void reply(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        String requestParameter = HttpUtil.getRequestParameter(request);
        ReplyBO replyBO = gson.fromJson(requestParameter, ReplyBO.class);
        int code=noReplyService.reply(replyBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }

    }

    /**
     * @Date:2020/12/16 11:05
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 删除规格表
     */
    private void deleteSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        DeleteSpecBO deleteSpecBO = gson.fromJson(requestParameter, DeleteSpecBO.class);
       int code= goodsService.deleteSpec(deleteSpecBO);
       if (code==200){
           response.getWriter().println(gson.toJson(Result.ok()));
       }
    }

    /**
     * @Date:2020/12/16 9:40
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 添加规格表
     */
    private void addSpec(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        AddSpecBO addSpecBO = gson.fromJson(requestParameter, AddSpecBO.class);
        int code=goodsService.addSpec(addSpecBO);
        if (code==200){
            System.out.println(addSpecBO);
            response.getWriter().println(gson.toJson(Result.ok(addSpecBO)));
        }
        if (code==404){
            response.getWriter().println(gson.toJson(Result.error("规格已存在")));
        }

    }

    /**
     * @Date:2020/12/15 17:14
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 更新商品信息
     */
    private void updateGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        UpdateGoodsBO updateGoodsBO = gson.fromJson(requestParameter, UpdateGoodsBO.class);
        goodsService.updateGoods(updateGoodsBO);
        response.getWriter().println(gson.toJson(Result.ok()));

    }

    private void addGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        添加商品信息
//        获取参数
        String requestParameter = HttpUtil.getRequestParameter(request);
        AddGoodsBO addGoodsBO=null;
        try{
            addGoodsBO = gson.fromJson(requestParameter, AddGoodsBO.class);
            System.out.println(addGoodsBO);
        }catch (Exception e){
            response.getWriter().println(gson.toJson(Result.error("参数不合法")));
            return;
        }

        int code=goodsService.addGoods(addGoodsBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
    }

    private void imgUpload(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        Map<String, Object> stringObjectMap = FileUploadUtils.parseRequest(request);
//        获取文件路径上传文件的路径
        String  file = (String) stringObjectMap.get("file");
//        由于上传的文件是在8084即本地的文件中，所以我们应该拼接一个全路径，前台才可以找到，应该写在监听器中
        //System.out.println(file);//
        ServletContext servletContext = getServletContext();
        String domain = (String) servletContext.getAttribute("domain");
        System.out.println(domain);
        file=domain+file;
//        写入响应体
        response.getWriter().println(gson.toJson(Result.ok(file)));
    }

    /**
     * @Date:2020/12/15 9:03
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 添加商品类目
     */

    private void addType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        获取请求数据，json
        String requestParameter = HttpUtil.getRequestParameter(request);
        GoodTypeBO goodTypeBO = gson.fromJson(requestParameter, GoodTypeBO.class);
//        判空
        if(!goodTypeBO.isEmpy()){
            response.getWriter().println(gson.toJson(Result.error("该分类不能为空")));
            return;
        }
        int code=goodsService.addType(goodTypeBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
        if (code==404){
            response.getWriter().println(gson.toJson(Result.error("该分类已存在")));
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/goods/", "");
        if ("getType".equals(replaceStr)){
            getType(request,response);
        }
        if("getGoodsByType".equals(replaceStr)){
            getGoodsByType(request,response);
        }
        if("getGoodsInfo".equals(replaceStr)){
            getGoodsInfo(request,response);
        }
        if("deleteGoods".equals(replaceStr)){
            deleteGoods(request,response);
        }
        if("deleteType".equals(replaceStr)){
            deleteType(request,response);
        }
        if ("noReplyMsg".equals(replaceStr)){
            noReplyMsg(request,response);
        }
        if ("repliedMsg".equals(replaceStr)){
            repliedMsg(request,response);
        }

    }

    private void repliedMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        无请求参数
        List<ReplyMagVO> replyMagVO=noReplyService.repliedMsg();
        response.getWriter().println(gson.toJson(Result.ok(replyMagVO)));
    }

    private void deleteType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("typeId"));
        System.out.println(id);
        int code=goodsService.deleteType(id);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
    }

    private void deleteGoods(HttpServletRequest request, HttpServletResponse response) throws IOException {

//        获取参数key-value
        Integer id = Integer.valueOf(request.getParameter("id"));
        int code=goodsService.deleteGoods(id);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }

    }

    private void getGoodsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数key-value
        int id = Integer.parseInt(request.getParameter("id"));
       Map<String, Object> map= goodsService.getGoodsInfo(id);
        response.getWriter().println(gson.toJson(Result.ok(map)));

    }

    private void getGoodsByType(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取请求参数
        int typeId = Integer.parseInt(request.getParameter("typeId"));
       List<GetGoodsVO> goodList=goodsService.getGoodsByType(typeId);
       response.getWriter().println(gson.toJson(Result.ok(goodList)));
    }


    private void getType(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       无参数，不需要校验
       List<GoodTypeVO> goodList= goodsService.getType();
       response.getWriter().println(gson.toJson(Result.ok(goodList)));
    }
    private void noReplyMsg(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        无请求参数
        List<NoReplyMaGVO> list= noReplyService.noReplyMsg();
        System.out.println(list);
        response.getWriter().println(gson.toJson(Result.ok(list)));

    }

}
