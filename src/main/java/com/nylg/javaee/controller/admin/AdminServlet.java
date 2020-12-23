package com.nylg.javaee.controller.admin;

import com.google.gson.Gson;
import com.nylg.javaee.bean.admin.*;
import com.nylg.javaee.bean.Result;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.bean.admin.BO.SearchAdminsCharBO;
import com.nylg.javaee.service.AdminService;
import com.nylg.javaee.service.serviceImpl.AdminServiceImpl;
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
 * @create: 2020/12/12 16:06
 * @Version: 1.0
 */
@WebServlet("/api/admin/admin/*")
public class AdminServlet extends HttpServlet {
    private Gson gson=new Gson();
    private AdminService adminService=new AdminServiceImpl();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      获取请求参数,相对路径获取
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/admin/", "");
        if ("login".equals(replaceStr)){
            login(request,response);
        }
        if ("updateAdminss".equals(replaceStr)){
            updateAdminss(request,response);
        }
        if ("addAdminss".equals(replaceStr)){
            addAdminess(request,response);
        }
        if ("getSearchAdmins".equals(replaceStr)){
            getSearchAdmins(request,response);
        }
        if ("changePwd".equals(replaceStr)){
            changPwd(request,response);
        }
        if("logoutAdmin".equals(replaceStr)){
            logoutAdmin(request,response);
        }
    }

    private void logoutAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().println(gson.toJson(Result.ok()));
        request.getSession().invalidate();
    }

    /**
     * @Date:2020/12/14 21:00
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 修改当前管理员的密码
     */
    private void changPwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String requestParameter = HttpUtil.getRequestParameter(request);
        AdminchangPwdBO adminchangPwdBO = gson.fromJson(requestParameter, AdminchangPwdBO.class);
//        TODO：校验，正则，两次密码是否相同
        int verify = adminchangPwdBO.isVerify();
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
        }


        int code=adminService.changPwd(adminchangPwdBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }
        if (code==404){
            response.getWriter().println(gson.toJson(Result.error("旧密码不正确")));
        }
        if (code==500){
            response.getWriter().println(gson.toJson(Result.error("系统繁忙")));
        }

    }

    /**
     * @Date:2020/12/14 19:00
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 条件查询管理员
     */
    private void getSearchAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {
//       获取请求数据，json
        String string =  HttpUtil.getRequestParameter(request);
        SearchAdminsCharBO searchAdminsCharBO = gson.fromJson(string, SearchAdminsCharBO.class);
        List<Admin> adminList=adminService.getSearchAdmins(searchAdminsCharBO);
        response.getWriter().println(gson.toJson(Result.ok(adminList)));
    }

    /**
     * @Date:2020/12/14 13:16
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 添加管理员的信息
     */
    private void addAdminess(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String string =  HttpUtil.getRequestParameter(request);
        AdminAddBO adminAddBO = gson.fromJson(string, AdminAddBO.class);
//        判断是否为空
        boolean flag=adminAddBO.isEmpy();
        if (flag){
            response.getWriter().println(gson.toJson(Result.error("参数不能为空")));
        }
        int code=adminService.addAdminess(adminAddBO);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }else if (code==401){
//            不允许重复，已经存在该管理员
            response.getWriter().println(gson.toJson(Result.error("该账号不允许重复使用")));
        }

//TODO:正则表达式判断返回
    }


    /**
     * @Date:2020/12/14 12:43
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 修改管理员信息
     */
    private void updateAdminss(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String string = HttpUtil.getRequestParameter(request);
//        将json字符串转化成为对象
        Admin admin = gson.fromJson(string, Admin.class);
//
        int code=adminService.updateAdminss(admin);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }

    }

    /**
     * @Date:2020/12/12 16:57
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 登录方法,获取请求数据，返回响应信息
     * 响应信息为json形式，应该获取响应信息
     * 返回的信息为json形式，其中code=0,表示登陆成功
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String string =  HttpUtil.getRequestParameter(request);
//        将json字符串转化成对象
        AdminUserBO loginBO = gson.fromJson(string, AdminUserBO.class);
//        拿到对象进行校验
        if (!loginBO.isValid()){
//            为空，返回，看借口返回的类型，进行返回
            response.getWriter().println(gson.toJson(Result.error("用户和密码不能为空")));
            return;

        }
//        不为空，调用service，进行业务层处理，根据API文档，可知返回数据为code，massage等
        int code = adminService.login(loginBO);
        System.out.println(code);
        if(code == 200){
            //输入正确
            HashMap<String, String> map = new HashMap<>();
            map.put("token", loginBO.getEmail());
            map.put("name", loginBO.getEmail());


            response.getWriter().println(gson.toJson(Result.ok(map)));
            //            添加到session域中
            request.getSession().setAttribute("email",loginBO.getEmail());
        }else if(code == 404){
            //用户名、密码错误
            response.getWriter().println(gson.toJson(Result.error("用户名或者密码错误")));
        }else {
            //500 服务器出现异常
            response.getWriter().println(gson.toJson(Result.error("当前服务器繁忙")));
        }


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //      获取请求参数,相对路径获取
        String requestURI = request.getRequestURI();
        String replaceStr = requestURI.replace("/api/admin/admin/", "");
        if ("allAdmins".equals(replaceStr)){
            allAdmins(request,response);
        }
        if ("deleteAdmins".equals(replaceStr)){
            deleteAdmin(request,response);
        }
        if("getAdminsInfo".equals(replaceStr)){
            getAdminsInfo(request,response);
        }

    }


    /**
     * @Date:2020/12/14 12:45
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 获取要修改的用户信息
     */
    private void getAdminsInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        Admin admin=adminService.getAdminsInfo(id);
        response.getWriter().println(gson.toJson(Result.ok(admin)));

    }
    /**
     * @Date:2020/12/14 12:45
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 删除管理员信息
     */
    private void deleteAdmin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        int code=adminService.deleteAdmin(id);
        if (code==200){
            response.getWriter().println(gson.toJson(Result.ok()));
        }else if (code==404){
            response.getWriter().println(gson.toJson(Result.error("删除失败")));
        }else{
            response.getWriter().println(gson.toJson(Result.error("系统繁忙")));
        }
    }
    /**
     * @Date:2020/12/14 12:48
     * @Param request:
     * @Param response:
     * @return: void
     * @Author:QSH
     * @Description: 获取所有管理员信息
     */
    private void allAdmins(HttpServletRequest request, HttpServletResponse response) throws IOException {

//      调用service
        List<Admin> admins=adminService.allAdmins();
        response.getWriter().println(gson.toJson(Result.ok(admins)));
    }
}
