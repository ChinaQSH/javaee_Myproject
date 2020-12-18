package com.nylg.javaee.dao.daoImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 19:31
 * @Version: 1.0
 */


import com.alibaba.druid.util.StringUtils;
import com.nylg.javaee.bean.admin.*;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.bean.admin.BO.SearchAdminsCharBO;
import com.nylg.javaee.dao.AdminDao;
import com.nylg.javaee.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *@Description:
 *
 */
public class AdminDaoImpl implements AdminDao {
    @Override
    public int login(AdminUserBO loginBO) {
//        查询数据返回结果
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            Long query = queryRunner.query("select count(*) from admin where email=? and pwd=?", new ScalarHandler<>(), loginBO.getEmail(), loginBO.getPwd());
            return query!=0?200:404;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 500;
    }

    @Override
    public List<Admin> allAdmins() {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<Admin> query=null;
        try {
             query = queryRunner.query("select * from admin", new BeanListHandler<>(Admin.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public int deleteAdmin(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            int update = queryRunner.update("delete from admin where id=?", id);
            return update==1?200:404;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 500;
    }

    @Override
    public Admin getAdminsInfo(int id) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        Admin query=null;
        try {
             query = queryRunner.query("select * from admin where id=?", new BeanHandler<>(Admin.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return query;
    }

    @Override
    public int updateAdminess(Admin admin) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
//TODO:正则判断
            queryRunner.update("update admin set email=?,nickname=?,pwd=? where id=?", admin.getEmail(), admin.getNickname(), admin.getPwd(), admin.getId());

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 200;
    }
    /**
     * @Date:2020/12/14 13:37
     * @Param adminAddBO:
     * @return: int
     * @Author:QSH
     * @Description: 添加管理员
     */
    @Override
    public int addAdminess(AdminAddBO adminAddBO) {
//        TODO：正则判断：

        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        int update = 0;
        Long query = null;
        try {
            query=queryRunner.query("select count(*) from admin where email=? or nickname=?", new ScalarHandler<>(), adminAddBO.getEmail(),adminAddBO.getNickname());
            if (query.intValue()==0){
                update = queryRunner.update("insert into admin values(null,?,?,?)", adminAddBO.getEmail(), adminAddBO.getNickname(), adminAddBO.getPwd());
                return update==1?200:404;
            }
            return 401;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 500;
    }
/**
 * @Date:2020/12/14 20:01
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 利用动态sql，模糊查询
 *
 */
    @Override
    public List<Admin> getSearchAdmins(SearchAdminsCharBO searchAdminsCharBO) {


//        String nickname = searchAdminsCharBO.getNickname();
//        String nickname1="%"+nickname+"%";
//        String email = searchAdminsCharBO.getEmail();
//        String email1="%"+email+"%";
//        动态SQL
        HashMap<String, Object> sqlParamer = getSqlParamer(searchAdminsCharBO);
        String baseSql = (String) sqlParamer.get("baseSql");
        List<String> arr = (List<String>) sqlParamer.get("arr");
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        List<Admin> query = null;
        try {
            query = queryRunner.query(baseSql, new BeanListHandler<Admin>(Admin.class),arr.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    public int changPwd(AdminchangPwdBO adminchangPwdBO) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        try {
            Long query = queryRunner.query("select count(*) from admin where nickname=? and pwd=?", new ScalarHandler<>(), adminchangPwdBO.getAdminToken(), adminchangPwdBO.getOldPwd());
            if (query.intValue()==1){
                queryRunner.update("update admin set pwd=? where nickname=?",adminchangPwdBO.getNewPwd(),adminchangPwdBO.getAdminToken());
                return 200;
            }
            return 404;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 500;
    }

    private HashMap getSqlParamer(SearchAdminsCharBO searchAdminsCharBO) {
//        获取sql,将sql返回，并且要将参数返回，参数只能是数组或变量，不能是对象
        ArrayList<String> strings = new ArrayList<>();
        String baseSql="select * from admin where 1=1 ";
       if (!StringUtils.isEmpty(searchAdminsCharBO.getEmail())){
           baseSql=baseSql+"and email like ?";
           strings.add("%"+searchAdminsCharBO.getEmail()+"%");
       }
       if (!StringUtils.isEmpty(searchAdminsCharBO.getNickname())){
           baseSql=baseSql+"and nickname like ?";
           strings.add("%"+searchAdminsCharBO.getNickname()+"%");
       }
//       返回到函数
        HashMap<String, Object> map = new HashMap<>();
       map.put("baseSql",baseSql);
       map.put("arr",strings);
       return map;
    }
}
