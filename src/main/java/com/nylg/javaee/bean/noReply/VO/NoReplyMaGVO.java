package com.nylg.javaee.bean.noReply.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 20:21
 * @Version: 1.0
 */

/**
 *@Description: 复现返回数据
 *
 */
public class NoReplyMaGVO {
    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private String content;
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
        user.setName(name);
    }

    public NoReplyMaGVO(Integer id, Integer userId, Integer goodsId, String content, Integer state, String createtime, GoodsNameVO goods, UserNameVO user) {
        this.id = id;
        this.userId = userId;
        this.goodsId = goodsId;
        this.content = content;
        this.state = state;
        this.createtime = createtime;
        this.goods = goods;
        this.user = user;
    }

    public NoReplyMaGVO() {
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

    @Override
    public String toString() {
        return "NoReplyMaGVO{" +
                "id=" + id +
                ", userId=" + userId +
                ", goodsId=" + goodsId +
                ", content='" + content + '\'' +
                ", state=" + state +
                ", createtime='" + createtime + '\'' +
                ", goods=" + goods +
                ", user=" + user +
                '}';
    }
}
