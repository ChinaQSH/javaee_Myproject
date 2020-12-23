package com.nylg.javaee.bean.order.VO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/19 15:23
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.VO.GetGoodsInfoIndex;

import java.util.List;

/**
 *@Description:
 *
 */
public class OrderInfoIndex {
    private Integer id;
    private Integer state;
    private Integer goodsNum;
    private Double amount;
    private Integer goodsDetailId;
    private String createtime;
    private boolean hasComment;
    private GetGoodsInfoIndex goods=new GetGoodsInfoIndex();
    private Integer ids;
    private String img;
    private String name;
    private Integer goodsDetailIds;
    private  Integer typeId;
    private String spec;
    private Double unitPrice;

    public void setIds(Integer ids) {
        goods.setId(ids);
    }

    public void setImg(String img) {
       goods.setImg(img);
    }

    public void setName(String name){
        goods.setName(name);
    }

    public void setGoodsDetailIds(Integer goodsDetailIds) {
        goods.setGoodsDetailId(goodsDetailIds);
    }

    public void setTypeId(Integer typeId) {
        goods.setTypeId(typeId);
    }

    public void setSpec(String spec) {
        goods.setSpec(spec);
    }

    public void setUnitPrice(Double unitPrice) {
        goods.setUnitPrice(unitPrice);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public Integer getGoodsDetailId() {
        return goodsDetailId;
    }

    public void setGoodsDetailId(Integer goodsDetailId) {
        this.goodsDetailId = goodsDetailId;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public boolean isHasComment() {
        return hasComment;
    }

    public void setHasComment(boolean hasComment) {
        this.hasComment = hasComment;
    }

    public GetGoodsInfoIndex getGoods() {
        return goods;
    }

    public void setGoods(GetGoodsInfoIndex goods) {
        this.goods = goods;
    }
}
