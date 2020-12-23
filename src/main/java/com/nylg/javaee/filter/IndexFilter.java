package com.nylg.javaee.filter;

import com.google.gson.Gson;
import com.nylg.javaee.bean.Result;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 16:09
 * @Version: 1.0
 */
@WebFilter("/api/mall/*")
public class IndexFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//转换
        HttpServletRequest request= (HttpServletRequest) req;
        HttpServletResponse response= (HttpServletResponse) resp;

        //        设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
//        跨域访问
        String origin = (String) request.getServletContext().getAttribute("origin");
        List<String> url = (List<String>) request.getServletContext().getAttribute("urlIndex");
        System.out.println(url);
        response.setHeader("Access-Control-Allow-Origin",origin);
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials","true");
        //List<String> url = (List<String>) request.getServletContext().getAttribute("urlIndex");
        String requestURI = request.getRequestURI();
       // String id = request.getSession().getId();
//        String email = (String) request.getSession().getAttribute("email");

        if (!request.getMethod().equals("OPTIONS")){

            for (String s : url) {
//                if (!"/api/admin/admin/login".equals(requestURI)||!"/api/admin/admin/logoutAdmin".equals(requestURI)){
//
//                }
//                if (!s.equals(requestURI)){
//                    break;
//                }

//                System.out.println(email);
                if (s.equals(requestURI)){
                    String email = (String) request.getSession().getAttribute("email");
                    System.out.println(email);
                    if (email==null){
                        response.getWriter().println(new Gson().toJson(Result.error("请先登录")));
                        return;
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
