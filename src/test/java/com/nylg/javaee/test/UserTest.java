package com.nylg.javaee.test;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:21
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.service.serviceImpl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 *@Description: 用户信息操作测试
 *
 */
public class UserTest {
    @Test
    public void allUser(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> users = userService.allUser();
        System.out.println(users);
    }
    @Test
    public void searchUser(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList = userService.searchUser("admin");
        System.out.println(userList);
    }
}
