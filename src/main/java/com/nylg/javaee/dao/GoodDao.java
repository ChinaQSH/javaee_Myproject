package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:17
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.*;
import com.nylg.javaee.bean.goods.BO.AddSpecBO;
import com.nylg.javaee.bean.goods.BO.DeleteSpecBO;
import com.nylg.javaee.bean.goods.BO.GoodTypeBO;
import com.nylg.javaee.bean.goods.BO.UpdateSpecListBO;
import com.nylg.javaee.bean.goods.VO.GetGoodInfoVO;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;

import java.util.List;

/**
 *@Description: 商品操作接口
 *
 */
public interface GoodDao {
    List<GoodTypeVO> getType();

    int addType(GoodTypeBO goodTypeBO);

    List<GetGoodsVO> getGoodsByType(int typeId);

    void addGoods(Goods goods);

    int getMaxId();


    void addSpecList(Object[][] objects);

    void updateGoods(Goods goods);

//    void updateSpecList(Object[][] objects);

    GetGoodInfoVO getGoodInfo(int id);

    List<UpdateSpecListBO> getSpecInfo(int id);

    int addSpec(AddSpecBO addSpecBO);

    int deleteSpec(DeleteSpecBO deleteSpecBO);

    int deleteGoods(Integer id);

    int deleteType(Integer id);

    List<GoodTypeBO> selectGoodId(Integer id);

    void deleteSpecId(GoodTypeBO goodId);

    void deleteGoodId(Integer id);
////最大库存量
//    int getMaxstockNum();

}
