package com.nylg.javaee.bean.noReply.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 23:31
 * @Version: 1.0
 */

/**
 *@Description: 留言回复
 *
 */
public class ReplyBO {
    private Integer id;
    private String content;

    public ReplyBO(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public ReplyBO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
