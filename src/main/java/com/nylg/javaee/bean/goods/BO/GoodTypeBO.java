package com.nylg.javaee.bean.goods.BO;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 23:23
 * @Version: 1.0
 */

import com.alibaba.druid.util.StringUtils;

/**
 *@Description: 商品分类返回Bean
 *
 */
public class GoodTypeBO {
    private String name;

    public GoodTypeBO(String name) {

        this.name = name;
    }

    public GoodTypeBO() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEmpy() {
        if (StringUtils.isEmpty(this.name)){
            return false;
        }
        return true;
    }
}
