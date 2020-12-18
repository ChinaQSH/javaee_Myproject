package com.nylg.javaee.util;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 19:45
 * @Version: 1.0
 */

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 *@Description:
 *
 */
public class HttpUtil {
    public static String getRequestParameter(HttpServletRequest request) throws IOException {
        /**
         * @Date:2020/12/14 13:21
         * @Param request:
         * @return: void
         * @Author:QSH
         * @Description: 获取请求体中参数
         */
        //        获取json请求参数
        ServletInputStream in = request.getInputStream();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len=in.read(bytes))!=-1){
            out.write(bytes,0,len);
        }
        String string = out.toString("utf-8");
        out.close();
        return string;
    }
}
