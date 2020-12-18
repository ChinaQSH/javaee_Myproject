package com.nylg.javaee.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 16:09
 * @Version: 1.0
 */
@WebFilter("/*")
public class ApplicationFilter implements Filter {
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
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Methods","POST,GET,OPTIONS,PUT,DELETE");
        response.setHeader("Access-Control-Allow-Headers","x-requested-with,Authorization,Content-Type");
        response.setHeader("Access-Control-Allow-Credentials","true");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
