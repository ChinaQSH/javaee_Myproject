package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 15:51
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.dao.UserDao;
import com.nylg.javaee.dao.daoImpl.UserDaoImpl;
import com.nylg.javaee.service.UserService;

import java.util.List;

/**
 *@Description: 后台管理的用户模块
 *
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();
    @Override
    public List<User> allUser() {
        return userDao.allUser();
    }

    @Override
    public int deleteUser(int id) {
        return userDao.deleteUser(id);
    }

    @Override
    public List<User> searchUser(String word) {
        return userDao.searchUser(word);
    }
}
