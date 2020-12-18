package com.nylg.javaee.service.serviceImpl;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 19:28
 * @Version: 1.0
 */

import com.nylg.javaee.bean.admin.*;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.bean.admin.BO.SearchAdminsCharBO;
import com.nylg.javaee.dao.AdminDao;
import com.nylg.javaee.dao.daoImpl.AdminDaoImpl;
import com.nylg.javaee.service.AdminService;

import java.util.List;

/**
 *@Description:
 *
 */
public class AdminServiceImpl implements AdminService {
   private AdminDao adminDao=new AdminDaoImpl();
    @Override
    public int login(AdminUserBO loginBO) {
         return adminDao.login(loginBO);
    }

    @Override
    public List<Admin> allAdmins() {
        return adminDao.allAdmins();
    }

    @Override
    public int deleteAdmin(int id) {
        return adminDao.deleteAdmin(id);
    }

    @Override
    public Admin getAdminsInfo(int id) {
        return adminDao.getAdminsInfo(id);
    }

    @Override
    public int updateAdminss(Admin admin) {
        return adminDao.updateAdminess(admin);
    }

    @Override
    public int addAdminess(AdminAddBO adminAddBO) {
        return adminDao.addAdminess(adminAddBO);
    }

    @Override
    public List<Admin> getSearchAdmins(SearchAdminsCharBO searchAdminsCharBO) {
        return adminDao.getSearchAdmins(searchAdminsCharBO);
    }

    @Override
    public int changPwd(AdminchangPwdBO adminchangPwdBO) {
        return adminDao.changPwd(adminchangPwdBO);
    }
}
