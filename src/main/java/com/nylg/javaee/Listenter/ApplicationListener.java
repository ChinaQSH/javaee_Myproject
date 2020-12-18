package com.nylg.javaee.Listenter; /**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/15 14:02
 * @Version: 1.0
 */

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
        InputStream inputStream = ApplicationListener.class.getClassLoader().getResourceAsStream("application.properties");
//      获取context域
        ServletContext servletContext = sce.getServletContext();
//        读取properties文件
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String domin = properties.getProperty("domain");
            System.out.println(domin);
            servletContext.setAttribute("domain",domin);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }
}
