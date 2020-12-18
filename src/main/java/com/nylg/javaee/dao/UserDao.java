package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:09
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.User;

import java.util.List;

/**
 *@Description: 用户信息操作
 *
 */
public interface UserDao {
    /**
     * @Date:2020/12/14 16:12
     * @Param null:
     * @return: null
     * @Author:QSH
     * @Description: 显示用户信息
     */
    List<User> allUser();

    int deleteUser(int id);

    List<User> searchUser(String word);
}
