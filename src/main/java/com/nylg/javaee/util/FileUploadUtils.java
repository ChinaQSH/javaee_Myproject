package com.nylg.javaee.util;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class FileUploadUtils {

    public static Map<String, Object> parseRequest(HttpServletRequest request){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        File repository = (File) request.getServletContext().getAttribute("javax.servlet.context.tempdir");
        factory.setRepository(repository);
        Map<String, Object> map = new HashMap<>();
        ServletFileUpload upload = new ServletFileUpload(factory);
        //上传的文件名如果有中文的乱码问题
        upload.setHeaderEncoding("utf-8");
        // 1024 bytes
        //upload.setSizeMax(1024);
        try {
            //items其实就是对于前端提交过来啊input的封装
            //提交过来多少个input，那么这边items就有多少个
            List<FileItem> items = upload.parseRequest(request);
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()){
                FileItem item = iterator.next();
                if(item.isFormField()){
                    //当前item是常规的form表单
                    processFormField(item, map);
                }else {
                    //当前item是上传的文件
                    processUploadedFile(item, map, request);
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return map;
    }

    private static void processUploadedFile(FileItem item, Map<String, Object> map, HttpServletRequest request) {
        String fieldName = item.getFieldName();
        String uuid = UUID.randomUUID().toString();
        String fileName = item.getName();
        //文件有后缀名的
        fileName = uuid + fileName;
        int hashCode = fileName.hashCode();
        String hexString = Integer.toHexString(hashCode);
        char[] chars = hexString.toCharArray();
        String uploadPath = "upload";
        for (char aChar : chars) {
            uploadPath = uploadPath + "/" +aChar;
        }
        uploadPath = uploadPath + "/" + fileName;
        String realPath = request.getServletContext().getRealPath(uploadPath);
        File file = new File(realPath);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        try {
            item.write(file);
            map.put(fieldName, uploadPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 处理常规form表单的逻辑
     * @param item
     * @param map
     */
    private static void processFormField(FileItem item, Map<String, Object> map) {
        //返回的就是input的name属性
        String name = item.getFieldName();
        String value = null;
        try {
            value = item.getString("utf-8");
            map.put(name, value);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("formField " + name + ":" + value);
    }
}
