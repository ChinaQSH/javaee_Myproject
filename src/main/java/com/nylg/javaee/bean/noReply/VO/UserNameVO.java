package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:19
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class UserNameVO {
    private String name;

    public UserNameVO(String name) {
        this.name = name;
    }

    public UserNameVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
