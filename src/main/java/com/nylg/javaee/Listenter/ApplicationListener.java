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
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

@WebListener
public class ApplicationListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
      */
      //      获取context域
        ServletContext servletContext = sce.getServletContext();
        InputStream inputStream = ApplicationListener.class.getClassLoader().getResourceAsStream("application.properties");
        String realPath = String.valueOf(ApplicationListener.class.getClassLoader().getResource("auth.txt"));
        ArrayList<String> strings = getUrlString(realPath);
        servletContext.setAttribute("url",strings);
        String realPathIndex = String.valueOf(ApplicationListener.class.getClassLoader().getResource("authIndex.txt"));
        ArrayList<String> urlString = getUrlString(realPathIndex);
        servletContext.setAttribute("urlIndex",urlString);
        //        读取properties文件
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            String domin = properties.getProperty("domain");
            String origin = properties.getProperty("origin");
            System.out.println(domin);
            servletContext.setAttribute("origin",origin);
            servletContext.setAttribute("domain",domin);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private ArrayList<String> getUrlString(String realPath) {
        ArrayList<String> strings = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(realPath.substring(6))));
            String str=null;
            while((str=bufferedReader.readLine())!=null){
//                添加到集合中
                strings.add(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return strings;
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }
}
