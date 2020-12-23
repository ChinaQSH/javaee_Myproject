package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 15:51
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.BO.UpdateDateIndex;
import com.nylg.javaee.bean.user.BO.UserLoginBO;
import com.nylg.javaee.bean.user.BO.UserchangPwdBO;
import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.bean.user.VO.UserNameVO;
import com.nylg.javaee.bean.user.VO.UserVO;
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

    @Override
    public int login(UserLoginBO userLoginBO) {
       return userDao.login(userLoginBO);


    }

    @Override
    public void signup(User user) {

        userDao.sigup(user);

    }

    @Override
    public int updatePwd(UserchangPwdBO userchangPwdBO) {

        return userDao.updatePwd(userchangPwdBO);
    }

    @Override
    public UserVO date(String token) {
        User date = userDao.date(token);
        Integer code=0;
        UserVO userVO = new UserVO(code,date.getId(), date.getEmail(), date.getNickname(), date.getRecipient(), date.getAddress(), date.getPhone());
        return userVO;
    }

    @Override
    public void updateUserData(UpdateDateIndex updateDateIndex) {


        userDao.updateUserData(updateDateIndex);
    }

    @Override
    public UserNameVO userName(UserLoginBO userLoginBO) {

        return userDao.userName(userLoginBO);
    }
}
