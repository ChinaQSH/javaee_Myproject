package com.nylg.javaee.test;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:48
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.BO.GoodTypeBO;
import com.nylg.javaee.bean.noReply.VO.NoReplyMaGVO;
import com.nylg.javaee.service.GoodsService;
import com.nylg.javaee.service.NoReplyService;
import com.nylg.javaee.service.serviceImpl.GoodServiceImpl;
import com.nylg.javaee.service.serviceImpl.NoReplyServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 *@Description: goods操作测试
 *
 */
public class GoodsTest {
    private GoodsService goodsService = new GoodServiceImpl();

    @Test
    public void testAddType() {
        GoodTypeBO goodTypeBO = new GoodTypeBO();
        goodTypeBO.setName("22");
        int i = goodsService.addType(goodTypeBO);
        Assert.assertEquals(404, i);
    }

    @Test
    public void testGetGoodsByType() {
        List<GetGoodsVO> goodsByType = goodsService.getGoodsByType(1);
        System.out.println(goodsByType);
    }

    @Test
    public void testGoodsByType() {
        NoReplyService noReplyService = new NoReplyServiceImpl();
        List<NoReplyMaGVO> noReplyMaGVOS = noReplyService.noReplyMsg();
        System.out.println(noReplyMaGVOS);
    }
}
