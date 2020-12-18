package com.nylg.javaee.dao;
/**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 19:31
 * @Version: 1.0
 */

import com.nylg.javaee.bean.admin.*;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.bean.admin.BO.SearchAdminsCharBO;

import java.util.List;

/**
 *@Description:
 *
 */
public interface AdminDao {

    /**
 * @Date:2020/12/12 19:32
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 处理登录模块的验证
 */
    int login(AdminUserBO loginBO);
/**
 * @Date:2020/12/14 19:35
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 获取全部管理员
 */
    List<Admin> allAdmins();

/**
 * @Date:2020/12/14 19:36
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 删除管理员
 */
    int deleteAdmin(int id);

    /**
     * @Date:2020/12/14 19:36
     * @Param null:
     * @return: null
     * @Author:QSH
     * @Description: 获取要修改的管理员信息·1
     */
    Admin getAdminsInfo(int id);

    /**
     * @Date:2020/12/14 19:37
     * @Param null:
     * @return: null
     * @Author:QSH
     * @Description: 修改管理员信息
     */
    int updateAdminess(Admin admin);

    /**
     * @Date:2020/12/14 19:37
     * @Param null:
     * @return: null
     * @Author:QSH
     * @Description: 添加管理员信息
     */

    int addAdminess(AdminAddBO adminAddBO);

    /**
     * @Date:2020/12/14 19:37
     * @Param null:
     * @return: null
     * @Author:QSH
     * @Description: 模糊查询管理员信息
     */
    List<Admin> getSearchAdmins(SearchAdminsCharBO searchAdminsCharBO);

    int changPwd(AdminchangPwdBO adminchangPwdBO);
}
