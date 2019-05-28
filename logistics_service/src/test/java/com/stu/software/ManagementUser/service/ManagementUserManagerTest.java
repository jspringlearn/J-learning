package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.place.service.SiteManagerTest;
import com.stu.software.service.GenericManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;


/*
 * @Author yyb
 * @Date 2019/5/27 18:33
 * @Version 1.0
 * */
public class ManagementUserManagerTest extends GenericManagerTestCase<Long, ManagementUser,ManagementUserManage> {

    private static final Logger logger = LogManager.getLogger(SiteManagerTest.class.getName());

    public ManagementUserManagerTest(Class<ManagementUser> persistentClass) {
        super(persistentClass);
    }


    ManagementUserManage managementUserManage;

    @Autowired
    public void setManagementUserManage(ManagementUserManage managementUserManage) {
        this.managementUserManage = managementUserManage;
        this.manager=this.managementUserManage;
    }

    @Test
   public void testSave(){
       logger.debug("This is a test method for AOP");
       List<ManagementUser> managementUserList=new ArrayList<ManagementUser>();
       for(int i=0;i<5;i++){
           ManagementUser managementUser=new ManagementUser();
           managementUserList.add(managementUser);
       }
       this.managementUserManage.save(managementUserList);
   }
}
