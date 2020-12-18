package com.nylg.javaee.bean.goods.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/16 11:06
 * @Version: 1.0
 */

/**
 *@Description: 删除规格参数
 *
 */
public class DeleteSpecBO {
    private String goodsId;
    private String specName;

    public DeleteSpecBO(String goodsId, String specName) {
        this.goodsId = goodsId;
        this.specName = specName;
    }

    public DeleteSpecBO() {
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }
}
