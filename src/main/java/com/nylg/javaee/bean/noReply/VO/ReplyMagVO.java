package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 09:43
 * @Version: 1.0
 */

/**
 *@Description:
 *
 */
public class ReplyMagVO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
    private String replyContent;
    private Integer state;
    private String createtime;
    private String goodsname;
    private String name;
    private GoodsNameVO goods=new GoodsNameVO();
    private UserNameVO user=new UserNameVO();

    public void setGoodsname(String goodsname) {
        goods.setName(goodsname);
    }
    public void setName(String name) {
//        goods.setName(name);
        user.setName(name);
    }


    public ReplyMagVO(Integer id, Integer userId, Integer goodsId, String content, String replyContent, Integer state, String createtime, GoodsNameVO goods, UserNameVO user) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.replyContent = replyContent;
        this.state = state;
        this.createtime = createtime;
        this.goods = goods;
        this.user = user;
    }

    public ReplyMagVO() {
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

    public GoodsNameVO getGoods() {
        return goods;
    }

    public void setGoods(GoodsNameVO goods) {
        this.goods = goods;
    }

    public UserNameVO getUser() {
        return user;
    }

    public void setUser(UserNameVO user) {
        this.user = user;
    }
}
