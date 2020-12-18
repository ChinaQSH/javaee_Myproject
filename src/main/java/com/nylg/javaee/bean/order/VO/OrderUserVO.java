package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:23
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class OrderUserVO {
    private String nickname;
    private String name;
    private String address;
    private String phone;

    public OrderUserVO(String nickname, String name, String address, String phone) {
        this.nickname = nickname;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public OrderUserVO() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
