package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:10
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.BO.UpdateDateIndex;
import com.nylg.javaee.bean.user.BO.UserLoginBO;
import com.nylg.javaee.bean.user.BO.UserchangPwdBO;
import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.bean.user.VO.UserNameVO;
import com.nylg.javaee.dao.UserDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 *@Description: 用户信息操作
 *
 */
public class UserDaoImpl implements UserDao {
    @Override
    public List<User> allUser() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<User> query = null;
        try {
            query = queryRunner.query("select * from user", new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int deleteUser(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("delete from user where id=?", id);
            return 200;
        } catch (SQLException e) {
            e.printStackTrace();
        }
     return 404;
    }

    @Override
    public List<User> searchUser(String word) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String word1="%"+word+"%";
        List<User> query = null;
        try {
            query = queryRunner.query("select * from user where nickname like ?", new BeanListHandler<>(User.class), word1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int login(UserLoginBO userLoginBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Long query = null;
        try {
            query = queryRunner.query("select count(*) from user where email=? and pwd=?", new ScalarHandler<>(), userLoginBO.getEmail(), userLoginBO.getPwd());
            return query.intValue()==1?200:404;
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return 500;
    }

    @Override
    public void sigup(User user) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("insert into user values(null,?,?,?,?,?,?)",user.getEmail(),
                    user.getNickname(),user.getPwd(),user.getRecipient(),user.getAddress(),user.getPhone());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int updatePwd(UserchangPwdBO userchangPwdBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {

                queryRunner.update("update user set pwd=? where id=?",userchangPwdBO.getNewPwd(),userchangPwdBO.getId());
                return 200;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 500;


    }

    @Override
    public User date(String token) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        User query = null;
        try {
            query = queryRunner.query("select * from user where email=?", new BeanHandler<>(User.class),token);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public void updateUserData(UpdateDateIndex updateDateIndex) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            queryRunner.update("update user set nickname=?,recipient=?,address=?,phone=? where id=?",updateDateIndex.getNickname(),updateDateIndex.getRecipient(),updateDateIndex.getAddress(),updateDateIndex.getPhone(),updateDateIndex.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserNameVO userName(UserLoginBO userLoginBO) {

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        UserNameVO query = null;
        try {
            query = queryRunner.query("select nickname as name from user where email=? and pwd=?", new BeanHandler<>(UserNameVO.class), userLoginBO.getEmail(), userLoginBO.getPwd());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }
}
