package com.nylg.javaee.bean.user.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/20 16:19
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description:
 *
 */
public class UpdateDateIndex {
    private Integer id;
    private String nickname;
    private String recipient;
    private String address;
    private String phone;

    public UpdateDateIndex(Integer id, String nickname, String recipient, String address, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }

    public UpdateDateIndex() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public int Checkout() {


        if (!this.nickname.matches("^\\w{4,15}")){
            return 402;
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
