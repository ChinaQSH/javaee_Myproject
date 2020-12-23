package com.nylg.javaee.service;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 15:50
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.BO.UpdateDateIndex;
import com.nylg.javaee.bean.user.BO.UserLoginBO;
import com.nylg.javaee.bean.user.BO.UserchangPwdBO;
import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.bean.user.VO.UserNameVO;
import com.nylg.javaee.bean.user.VO.UserVO;

import java.util.List;

/**
 *@Description: 后台用户模块块
 *
 */
public interface UserService {
    /**
     * @Date:2020/12/14 16:08
     * @Param null:
     * @return: List
     * @Author:QSH
     * @Description: 显示用户的信息
     */
    List<User> allUser();
/**
 * @Date:2020/12/14 17:13
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 删除用户
 */
    int deleteUser(int id);

    List<User> searchUser(String word);

    int login(UserLoginBO userLoginBO);

    void signup(User user);

    int updatePwd(UserchangPwdBO userchangPwdBO);


    UserVO date(String token);

    void updateUserData(UpdateDateIndex updateDateIndex);


    UserNameVO userName(UserLoginBO userLoginBO);
}
