package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 09:37
 * @Version: 1.0
 */

/**
 *@Description: 已回复的bean
 *
 */
public class ReplyVO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
    private String replyContent;
    private Integer state;
    private String createtime;
//    private GoodsNameVO goods;
//    private UserNameVO user;

    public ReplyVO(Integer id, Integer userId, Integer goodsId, String content, String replyContent, Integer state, String createtime) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.replyContent = replyContent;
        this.state = state;
        this.createtime = createtime;
    }

    public ReplyVO() {
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

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
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
}
