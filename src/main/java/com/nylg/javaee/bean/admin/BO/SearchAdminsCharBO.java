package com.nylg.javaee.bean.admin.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 19:07
 * @Version: 1.0
 */

/**
 *@Description: 条件模糊查询参数
 *
 */
public class SearchAdminsCharBO {
    private String nickname;
    private String email;

    public SearchAdminsCharBO(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public SearchAdminsCharBO() {
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
