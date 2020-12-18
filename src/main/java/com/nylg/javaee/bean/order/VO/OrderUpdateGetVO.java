package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/17 17:09
 * @Version: 1.0
 */

import com.nylg.javaee.bean.order.OrderCurSpec;
import com.nylg.javaee.bean.order.OrderCurState;

import java.util.List;

/**
 *@Description: 显示修改页面
 *
 */
public class OrderUpdateGetVO {
    private Integer id;
    private Double amount;
    private Integer num;
    private Integer goodsDetailId;
    private Integer state;
    private String goods;
    private List<OrderUpdateSpecVO> spec;
    private List<OrderUpdateGetstatesVO> states;
    private OrderCurState curState;
    private OrderCurSpec curSpec;

    public OrderUpdateGetVO(Integer id, Double amount, Integer num, Integer goodsDetailId, Integer state, String goods, List<OrderUpdateSpecVO> spec, List<OrderUpdateGetstatesVO> states, OrderCurState curState, OrderCurSpec curSpec) {
        this.id = id;
        this.amount = amount;
        this.num = num;
        this.goodsDetailId = goodsDetailId;
        this.state = state;
        this.goods = goods;
        this.spec = spec;
        this.states = states;
        this.curState = curState;
        this.curSpec = curSpec;
    }

    public OrderUpdateGetVO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public List<OrderUpdateSpecVO> getSpec() {
        return spec;
    }

    public void setSpec(List<OrderUpdateSpecVO> spec) {
        this.spec = spec;
    }

    public List<OrderUpdateGetstatesVO> getStates() {
        return states;
    }

    public void setStates(List<OrderUpdateGetstatesVO> states) {
        this.states = states;
    }

    public OrderCurState getCurState() {
        return curState;
    }

    public void setCurState(OrderCurState curState) {
        this.curState = curState;
    }

    public OrderCurSpec getCurSpec() {
        return curSpec;
    }

    public void setCurSpec(OrderCurSpec curSpec) {
        this.curSpec = curSpec;
    }

    @Override
    public String toString() {
        return "OrderUpdateGetVO{" +
                "id=" + id +
                ", amount=" + amount +
                ", num=" + num +
                ", goodsDetailId=" + goodsDetailId +
                ", state=" + state +
                ", goods='" + goods + '\'' +
                ", spec=" + spec +
                ", states=" + states +
                ", curState=" + curState +
                ", curSpec=" + curSpec +
                '}';
    }
}
