package com.nylg.javaee.bean.user;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:02
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 管理模块用户信息
 *
 */
public class User {
    private Integer id;
    private String email;
    private String nickname;
    private String pwd;
    private String recipient;
    private String address;
    private String phone;

    public User(Integer id, String email, String nickname, String pwd, String recipient, String address, String phone) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.pwd = pwd;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", recipient='" + recipient + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int Checkout() {
        if (StringUtils.isEmpty(this.email)||StringUtils.isEmpty(this.nickname)||StringUtils.isEmpty(this.pwd)||StringUtils.isEmpty(this.recipient)||StringUtils.isEmpty(this.address)||StringUtils.isEmpty(phone)){
            return 400;
        }
        if (!this.email.matches("^[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")){
            return 401;
        }
        if (!this.nickname.matches("^\\w{4,15}")){
            return 402;
        }
        if (!this.pwd.matches("(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{8,15}$")){
            return 403;
        }
        if (!this.recipient.matches("[\\u4e00-\\u9fa5]{1,10}")){
            return 405;
        }
        if (!this.address.matches("[\\u4e00-\\u9fa5]{1,20}")){
            return 406;
        }
        if (!this.phone.matches("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$")){
            return 407;
        }
        return 200;
    }
}
