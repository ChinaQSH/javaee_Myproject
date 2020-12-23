package com.nylg.javaee.controller.index;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.bean.user.BO.UpdateDateIndex;
import com.nylg.javaee.bean.user.BO.UserLoginBO;
import com.nylg.javaee.bean.user.BO.UserchangPwdBO;
import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.bean.user.VO.UserLoginVO;
import com.nylg.javaee.bean.user.VO.UserNameVO;
import com.nylg.javaee.bean.user.VO.UserVO;
import com.nylg.javaee.service.GoodsService;
import com.nylg.javaee.service.UserService;
import com.nylg.javaee.service.serviceImpl.GoodServiceImpl;
import com.nylg.javaee.service.serviceImpl.UserServiceImpl;
import com.nylg.javaee.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 15:13
 * @Version: 1.0
 */
@WebServlet("/api/mall/user/*")
public class UserServlet extends HttpServlet {
    private Gson gson=new Gson();
    private UserService userService=new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/user/", "");
        if ("login".equals(replaceStr)){
            login(request,response);
        }
        if ("logoutClient".equals(replaceStr)){
            logoutClient(request,response);
        }
        if ("signup".equals(replaceStr)){
            signup(request,response);
        }
        if ("updatePwd".equals(replaceStr)){
            updatePwd(request,response);
        }
        if ("updateUserData".equals(replaceStr)){
            updateUserData(request,response);
        }
    }

    private void updateUserData(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        更改基本信息
        String requestParameter = HttpUtil.getRequestParameter(request);
        UpdateDateIndex updateDateIndex = gson.fromJson(requestParameter, UpdateDateIndex.class);
        int codes = updateDateIndex.Checkout();
        //        校验
        if(codes==402){
            response.getWriter().println(gson.toJson(Result.error("昵称正则验证未通过(只能包括数字字母的组合，长度为4-15位)")));
            return;
        }else if(codes==405){
            response.getWriter().println(gson.toJson(Result.error("收货人正则验证未通过必须为汉字")));
            return;
        }else if(codes==406){
            response.getWriter().println(gson.toJson(Result.error("收货地址正则验证未通过必须为汉字")));
            return;
        }else if(codes==407){
            response.getWriter().println(gson.toJson(Result.error("手机号正则验证未通过必须为11为")));
            return;
        }
        userService.updateUserData(updateDateIndex);
        response.getWriter().println(gson.toJson(Result.ok()));

    }

    private void updatePwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        UserchangPwdBO userchangPwdBO = gson.fromJson(requestParameter, UserchangPwdBO.class);
        int verify = userchangPwdBO.isVerify();

        if (verify==401){
            response.getWriter().println(gson.toJson(Result.error("密码不能为空")));
            return;
        }
        if(verify==402){
            response.getWriter().println(gson.toJson(Result.error("两次密码不相同")));
            return;
        }
        if (verify==403){
            response.getWriter().println(gson.toJson(Result.error("密码正则验证未通过(最少8位,最多16位，至少1个大写字母，1个小写字母，1个数字和1个特殊)")));
            return;
        }

        int code=userService.updatePwd(userchangPwdBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
        if (code==500){
            response.getWriter().println(gson.toJson(Result.error("系统繁忙")));
        }
    }

    /**
     * @Date:2020/12/20 13:09
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 注册页面
     */
    private void signup(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        User user = gson.fromJson(requestParameter, User.class);
//        校验
        int codes=user.Checkout();
//        校验
        if (codes==400){
            response.getWriter().println(gson.toJson(Result.error("参数不能为空")));
            return;
        }else if(codes==401){
            response.getWriter().println(gson.toJson(Result.error("email的正则不正确")));
            return;
        }else if(codes==402){
            response.getWriter().println(gson.toJson(Result.error("昵称正则验证未通过(只能包括数字字母的组合，长度为4-15位)")));
            return;
        }else if(codes==403){
            response.getWriter().println(gson.toJson(Result.error("密码正则验证未通过(最少8位,最多16位，至少1个大写字母，1个小写字母，1个数字和1个特殊)")));
            return;
        }else if(codes==405){
            response.getWriter().println(gson.toJson(Result.error("收货人正则验证未通过必须为汉字")));
        }else if(codes==406){
            response.getWriter().println(gson.toJson(Result.error("收货地址正则验证未通过必须为汉字")));
            return;
        }else if(codes==407){
            response.getWriter().println(gson.toJson(Result.error("手机号正则验证未通过必须为11为")));
            return;
        }
//
        userService.signup(user);
        HashMap<String, Object> map = new HashMap<>();
        int code=0;
        String name = user.getEmail();
        String token = user.getEmail();
        map.put("code",code);
        map.put("name",name);
        map.put("token",token);
        response.getWriter().println(gson.toJson(Result.ok(map)));

    }

    private void logoutClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(gson.toJson(Result.ok()));
        request.getSession().invalidate();
    }

    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        UserLoginBO userLoginBO = gson.fromJson(requestParameter, UserLoginBO.class);
        int code=userService.login(userLoginBO);
        UserNameVO userNameVO=userService.userName(userLoginBO);
        if (code==200){
            UserLoginVO userLoginVO = new UserLoginVO(0, userNameVO.getName(), userLoginBO.getEmail());
            System.out.println(userLoginVO);
            System.out.println(userLoginVO.getToken());
//            request.getSession().setAttribute("email",userLoginVO.getToken());
            response.getWriter().println(gson.toJson(Result.ok(userLoginVO)));
            String id = request.getSession().getId();
            System.out.println(id);
            request.getSession().setAttribute("email",userLoginVO.getToken());
            System.out.println(request.getSession().getAttribute("email"));
        }
        if (code==404){
            response.getWriter().println(gson.toJson(Result.error("密码或账号不正确")));
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/mall/user/", "");
        if ("data".equals(replaceStr)){
            data(request,response);
        }

    }

    private void data(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        获取参数
        String token = request.getParameter("token");
        UserVO user=userService.date(token);
        response.getWriter().println(gson.toJson(Result.ok(user)));
    }


}
