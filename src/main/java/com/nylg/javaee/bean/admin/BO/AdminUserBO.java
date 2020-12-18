package com.nylg.javaee.bean.admin.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 19:04
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 登录用户验证的Bean
 *BO一般指客户端请求要使用的信息
 * VO一般指服务端返回客户端的Bean
 */
public class AdminUserBO {
    private String email;
    private String pwd;

    public AdminUserBO() {
    }

    public AdminUserBO(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public boolean isValid() {
        if (StringUtils.isEmpty(this.email.trim())||StringUtils.isEmpty(this.pwd.trim())){
            return false;
        }
        return true;
    }
}
