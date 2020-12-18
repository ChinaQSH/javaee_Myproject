package com.nylg.javaee.controller;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.service.UserService;
import com.nylg.javaee.service.serviceImpl.UserServiceImpl;

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
 * @create: 2020/12/14 15:35
 * @Version: 1.0
 */
@WebServlet("/api/admin/user/*")
public class UserServlet extends HttpServlet {
  private UserService userService=  new UserServiceImpl();
  private Gson gson=new Gson();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/user/", "");
        if ("allUser".equals(replaceStr)){
            allUser(request,response);
        }
        if ("deleteUser".equals(replaceStr)){
            deleteUser(request,response);
        }
        if ("searchUser".equals(replaceStr)){
            searchUser(request,response);
        }
    }
    /**
     * @Date:2020/12/14 17:29
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 获取模糊查找信息
     */
    private void searchUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       获取key-value参数
        String word = request.getParameter("word");
        List<User> users=userService.searchUser(word);
        response.getWriter().println(gson.toJson(Result.ok(users)));
    }
    /**
     * @Date:2020/12/14 17:28
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 删除用户
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //        参数为key-value类型
        int id = Integer.parseInt(request.getParameter("id"));
        int code=userService.deleteUser(id);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));

        }else{
            response.getWriter().println(gson.toJson(Result.error("删除失败")));
        }
    }
    /**
     * @Date:2020/12/14 17:28
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 获取全部用户
     */
    private void allUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
       List<User> userList= userService.allUser();
       response.getWriter().println(gson.toJson(Result.ok(userList)));
    }
}
