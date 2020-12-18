package com.nylg.javaee.test; /**
 * @Created by IntelliJ IDEA.
 * @Auther: qushihao_java@aliyun.com
 * @User: Shi Hao Qu
 * @create: 2020/12/12 20:08
 * @Version: 1.0
 */

import com.nylg.javaee.bean.admin.Admin;
import com.nylg.javaee.bean.admin.BO.AdminAddBO;
import com.nylg.javaee.bean.admin.BO.AdminUserBO;
import com.nylg.javaee.bean.admin.BO.AdminchangPwdBO;
import com.nylg.javaee.service.serviceImpl.AdminServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 *@Description: 测试登录
 *
 */
public class AdminTest {
    @Test
    public void testService(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminUserBO adminUserBO = new AdminUserBO("admin", "admin");
        int code = adminService.login(adminUserBO);
        Assert.assertEquals(200,code);

    }
    @Test
    public void testallAdmin(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        List<Admin> admins = adminService.allAdmins();
        System.out.println(admins);
    }
//    @Test
//    public void testalldeleteAdmin(){
//        AdminServiceImpl adminService = new AdminServiceImpl();
//        int code = adminService.deleteAdmin(3);
//       Assert.assertEquals(200,code);
//    }
/**
 * @Date:2020/12/13 20:13
 * @Param null:
 * @return: null
 * @Author:QSH
 * @Description: 测试获取要修改的对象
 */
    @Test
    public void testGetAdminsInfo(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        Admin adminsInfo = adminService.getAdminsInfo(2);
        System.out.println(adminsInfo);
    }


    @Test
    public void testupdateAdminss(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        Admin admin = new Admin(4,"2","2","2");
       int code = adminService.updateAdminss(admin);
        Assert.assertEquals(200,code);
    }
    @Test
    public void testaddAdmines(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminAddBO adminAddBO = new AdminAddBO();
        adminAddBO.setEmail("12345678@qq.com");
        adminAddBO.setNickname("zs123");
        adminAddBO.setPwd("q@123456W");
        int i = adminService.addAdminess(adminAddBO);
        Assert.assertEquals(401,i);
    }
    @Test
    public void testchangPwd(){
        AdminServiceImpl adminService = new AdminServiceImpl();
        AdminchangPwdBO adminchangPwdBO = new AdminchangPwdBO("1","1","23","23");
        int i = adminService.changPwd(adminchangPwdBO);
        System.out.println(i);
    }


}
