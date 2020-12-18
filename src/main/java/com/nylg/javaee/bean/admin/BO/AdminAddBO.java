package com.nylg.javaee.bean.admin.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 13:14
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 添加用户信息的bean
 *
 */
public class AdminAddBO {
    private String email;

    private String nickname;

    private String pwd;

    public AdminAddBO(String nickname, String email, String pwd) {
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
    }

    public AdminAddBO() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public boolean isEmpy() {
        if (StringUtils.isEmpty(this.email.trim())||StringUtils.isEmpty(this.nickname.trim())||StringUtils.isEmpty(this.pwd.trim())){
            return true;
        }
        return false;

    }
}
