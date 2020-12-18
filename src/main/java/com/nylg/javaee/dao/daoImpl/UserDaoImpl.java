package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/14 16:10
 * @Version: 1.0
 */

import com.nylg.javaee.bean.user.User;
import com.nylg.javaee.dao.UserDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

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
}
