package com.nylg.javaee.bean.user.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:02
 * @Version: 1.0
 */

/**
 *@Description: 管理模块用户信息
 *
 */
public class UserVO {
    private Integer id;
    private String email;
    private String nickname;
    private String recipient;
    private String address;
    private String phone;

    public UserVO(Integer id, String email, String nickname, String recipient, String address, String phone) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.recipient = recipient;
        this.address = address;
        this.phone = phone;
    }

    public UserVO() {
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

    public String getAddname() {
        return recipient;
    }

    public void setAddname(String recipient) {
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
                ", addressname='" + recipient + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
