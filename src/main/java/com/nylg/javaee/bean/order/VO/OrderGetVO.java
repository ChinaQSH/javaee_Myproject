package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 14:19
 * @Version: 1.0
 */

/**
 *@Description: 查找显示数据，响应体的结构
 *
 */
public class OrderGetVO {
    private Integer id;
    private Integer userId;
    private Integer goodsDetailId;
    private String goods;
    private String spec;
    private Integer goodsNum;
    private Double amount;
    private Integer stateId;
    private String state;
    private String nickname;
    private String name;
    private String address;
    private String phone;
    private OrderUserVO user=new OrderUserVO();

    public void setNickname(String nickname) {
        user.setNickname(nickname);
    }

    public void setName(String name) {
        user.setName(name);
    }

    public void setAddress(String address) {
        user.setAddress(address);
    }

    public void setPhone(String phone) {
        user.setPhone(phone);
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

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getStateId() {
        return stateId;
    }
    /**
     * 在给stateId赋值的时候肯定会调用该方法
     * 0 未付款
     * 1 未发货
     * 2 已发货
     * 3 已到货
     * @param
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
        if (this.stateId==0){
         setState("未付款");
        }
        if (this.stateId==1){
            setState("未发货");
        }
        if (this.stateId==2){
            setState("已发货");
        }
        if (this.stateId==3){
            setState("已到货");
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public OrderUserVO getOrderUserVO() {
        return user;
    }

    public void setOrderUserVO(OrderUserVO user) {
        this.user = user;
    }
}
