package com.nylg.javaee.bean.user.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/18 19:54
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class UserLoginVO {
    private Integer code;
    private String name;
    private String token;

    public UserLoginVO(Integer code, String name, String token) {
        this.code = code;
        this.name = name;
        this.token = token;
    }

    public UserLoginVO() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
