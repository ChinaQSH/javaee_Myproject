package com.nylg.javaee.bean.user.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 21:02
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 修改密码
 *
 */
public class UserchangPwdBO {
    private Integer id;
    private String oldPwd;
    private String newPwd;
    private String confirmPwd;

    public UserchangPwdBO(Integer id, String oldPwd, String newPwd, String confirmPwd) {
        this.id = id;
        this.oldPwd = oldPwd;
        this.newPwd = newPwd;
        this.confirmPwd = confirmPwd;
    }

    public UserchangPwdBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public int isVerify() {
        if (StringUtils.isEmpty(this.oldPwd)||StringUtils.isEmpty(this.newPwd)||StringUtils.isEmpty(this.confirmPwd)){
            return 401;
        }
        if (!this.newPwd.equals(this.confirmPwd)){
            return 402;
        }
        if (!this.newPwd.matches("(?=.*([a-zA-Z].*))(?=.*[0-9].*)[a-zA-Z0-9-*/+.~!@#$%^&*()]{8,15}$")){
            return 403;
        }
        return 201;
    }
}
