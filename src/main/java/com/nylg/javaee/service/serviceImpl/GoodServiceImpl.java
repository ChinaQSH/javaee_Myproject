package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:16
 * @Version: 1.0
 */

import com.nylg.javaee.bean.goods.*;
import com.nylg.javaee.bean.goods.BO.*;
import com.nylg.javaee.bean.goods.VO.GetGoodInfoVO;
import com.nylg.javaee.bean.goods.VO.GetGoodsVO;
import com.nylg.javaee.bean.goods.VO.GoodTypeVO;
import com.nylg.javaee.dao.GoodDao;
import com.nylg.javaee.dao.daoImpl.GoodDaoImpl;
import com.nylg.javaee.service.GoodsService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *@Description: 商品信息的操作
 *
 */
public class GoodServiceImpl implements GoodsService {
    private GoodDao goodDao=new GoodDaoImpl();

    @Override
    public List<GoodTypeVO> getType() {
        return goodDao.getType();
    }

    @Override
    public int addType(GoodTypeBO goodTypeBO) {
        return goodDao.addType(goodTypeBO);
    }

    @Override
    public List<GetGoodsVO> getGoodsByType(int typeId) {
        return goodDao.getGoodsByType(typeId);
    }

    @Override
    public int addGoods(AddGoodsBO addGoodsBO) {
//        添加商品的逻辑
//        1.添加good表中
//        2.添加到spec表中（规格表）
//        首先应该获取goods表中的价格，价格应该是最低价格，然后获取库存量，库存为最大库存
        List<SpecListBO> specListBO = addGoodsBO.getSpecList();
        System.out.println(specListBO.get(0));
        Double unitPrice = specListBO.get(0).getUnitPrice();
        Integer stockNum = specListBO.get(0).getStockNum();
        for (int i = 1; i <specListBO.size() ; i++) {
            if (specListBO.get(i).getUnitPrice()<unitPrice){
                unitPrice=specListBO.get(i).getUnitPrice();
            }
            if (stockNum<specListBO.get(i).getStockNum()){
                stockNum=specListBO.get(i).getStockNum();
            }

        }
//        获得最小数据，插入到数据库
        Goods goods = new Goods(null,addGoodsBO.getImg(),addGoodsBO.getName(),unitPrice,addGoodsBO.getTypeId(),stockNum,addGoodsBO.getDesc());
        goodDao.addGoods(goods);

//添加到规格表
//        隔离要获取goodId，需要同步，所以事务。
//        TODO：事务
        int id=goodDao.getMaxId();
//        批处理
        Object[][] objects = new Object[specListBO.size()][];
        for (int i=0;i<objects.length;i++){
            SpecListBO specListBO1 = specListBO.get(i);
            objects[i]=new Object[]{
                    specListBO1.getSpecName(),specListBO1.getStockNum(),specListBO1.getUnitPrice(),id
            };
        }
        goodDao.addSpecList(objects);
        return 200;
    }

    @Override
    public void updateGoods(UpdateGoodsBO updateGoodsBO) {
//        修改商品表信息
//        拿到最大库存量和最低价
        List<UpdateSpecListBO> specList = updateGoodsBO.getSpecList();
        System.out.println(specList.get(0));
        Double unitPrice = specList.get(0).getUnitPrice();
        Integer stockNum = specList.get(0).getStockNum();
        for (int i = 1; i <specList.size() ; i++) {
            if (specList.get(i).getUnitPrice()<unitPrice){
                unitPrice=specList.get(i).getUnitPrice();
            }
            if (stockNum<specList.get(i).getStockNum()){
                stockNum=specList.get(i).getStockNum();
            }

        }
//        拿到数据，修改
        Goods goods = new Goods(updateGoodsBO.getId(), updateGoodsBO.getImg(), updateGoodsBO.getName(), unitPrice, updateGoodsBO.getTypeId(), stockNum, updateGoodsBO.getDesc());
        goodDao.updateGoods(goods);



//        批处理
        //        批处理
//        Object[][] objects = new Object[specList.size()][];
//        for (int i=0;i<objects.length;i++){
//            UpdateSpecListBO updateSpecListBO = specList.get(i);
//            objects[i]=new Object[]{
//                    updateSpecListBO.getId(),updateSpecListBO.getSpecName(),updateSpecListBO.getStockNum(),updateSpecListBO.getUnitPrice(),updateGoodsBO.getId()
//            };
//        }
//        goodDao.updateSpecList(objects);

    }

    @Override
    public Map<String, Object> getGoodsInfo(int id) {
//        查询goods和spec
        GetGoodInfoVO object= (GetGoodInfoVO) goodDao.getGoodInfo(id);
//        查询spec
        List<UpdateSpecListBO> specList=goodDao.getSpecInfo(id);
        HashMap<String, Object> map = new HashMap<>();

        map.put("specs",specList);
        map.put("goods",object);
        return map;
    }

    @Override
    public int addSpec(AddSpecBO addSpecBO) {
        return goodDao.addSpec(addSpecBO);
    }

    @Override
    public int deleteSpec(DeleteSpecBO deleteSpecBO) {
        return goodDao.deleteSpec(deleteSpecBO);
    }

    @Override
    public int deleteGoods(Integer id) {
        return goodDao.deleteGoods(id);
    }

    @Override
    public int deleteType(Integer id) {
//        通过id查询该分类下的所有商品id
        List<GoodTypeBO> goodIds=goodDao.selectGoodId(id);
        for (GoodTypeBO goodId : goodIds) {
            goodDao.deleteSpecId(goodId);

        }
        goodDao.deleteGoodId(id);
        return goodDao.deleteType(id);
    }
}
