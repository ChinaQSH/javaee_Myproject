package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:18
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class GoodsNameVO {
    private String name;

    public GoodsNameVO(String name) {
        this.name = name;
    }

    public GoodsNameVO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
