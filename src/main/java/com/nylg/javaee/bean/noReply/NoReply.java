package com.nylg.javaee.bean.noReply;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 19:50
 * @Version: 1.0
 */

import java.util.Date;

/**
 *@Description: 留言表
 *
 */
public class NoReply {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
    private Integer state;
    private String createtime;

    public NoReply(Integer id, Integer userId, Integer goodsId, String content, Integer state, String createtime) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.state = state;
        this.createtime = createtime;
    }

    public NoReply() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "NoReply{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createtime='" + createtime + '\'' +
                '}';
    }
}
