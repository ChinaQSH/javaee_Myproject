package com.nylg.javaee.service;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:16
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.BO.*;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;

import java.util.List;
import java.util.Map;

/**
 *@Description: 商品信息操作
 *
 */
public interface GoodsService {
    List<GoodTypeVO> getType();
/**
 * @Date:2020/12/15 9:09
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 添加商品分类
 */
    int addType(GoodTypeBO goodTypeBO);
/**
 * @Date:2020/12/15 10:53
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 获取商品信息
 */
    List<GetGoodsVO> getGoodsByType(int typeId);

    int addGoods(AddGoodsBO addGoodsBO);

    void updateGoods(UpdateGoodsBO updateGoodsBO);

    Map<String, Object> getGoodsInfo(int id);

    int addSpec(AddSpecBO addSpecBO);

    int deleteSpec(DeleteSpecBO deleteSpecBO);

    int deleteGoods(Integer id);

    int deleteType(Integer id);
}
