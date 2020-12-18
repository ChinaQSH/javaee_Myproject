package com.nylg.javaee.service;

import com.nylg.javaee.bean.admin.*;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.bean.admin.BO.SearchAdminsCharBO;

import java.util.List;

/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 19:26
 * @Version: 1.0
 */
public interface AdminService {
    /**
     * @Date:2020/12/14 13:28
     * @Param AdminUserBO:
     * @return: int
     * @Author:QSH
     * @Description: 登录
     */
    int login(AdminUserBO loginBO);

    /**
     * @Date:2020/12/14 13:29
     * @Param null:
     * @return: List
     * @Author:QSH
     * @Description: 获取管理员
     */

    List<Admin> allAdmins();

/**
 * @Date:2020/12/14 13:29
 * @Param int:
 * @return: int
 * @Author:QSH
 * @Description: 删除管理员信息
 */
    int deleteAdmin(int id);

    /**
     * @Date:2020/12/14 13:30
     * @Param int:
     * @return: Admin
     * @Author:QSH
     * @Description: 获取要修改的管理员信息
     */

    Admin getAdminsInfo(int id);
    /**
     * @Date:2020/12/14 13:30
     * @Param Admin:
     * @return: int
     * @Author:QSH
     * @Description: 修改管理员信息
     */

    int updateAdminss(Admin admin);

    /**
     * @Date:2020/12/14 13:31
     * @Param int:
     * @return: AdminAddBO
     * @Author:QSH
     * @Description: 添加管理员
     */
    int addAdminess(AdminAddBO adminAddBO);
/**
 * @Date:2020/12/14 21:07
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 模糊查找
 */
    List<Admin> getSearchAdmins(SearchAdminsCharBO searchAdminsCharBO);
/**
 * @Date:2020/12/14 21:07
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 修改密码
 */
    int changPwd(AdminchangPwdBO adminchangPwdBO);
}
