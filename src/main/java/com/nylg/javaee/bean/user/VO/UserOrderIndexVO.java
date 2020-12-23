package com.nylg.javaee.bean.user.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 13:18
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description:添加订单的user信息
 *
 */
public class UserOrderIndexVO {
    private Integer id;
    private String nickname;
    private String recipient;
    private String address;
    private String phone;

    public UserOrderIndexVO(Integer id, String nickname, String recipient, String address, String phone) {
        this.id = id;
        this.nickname = nickname;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }

    public UserOrderIndexVO() {
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

}
