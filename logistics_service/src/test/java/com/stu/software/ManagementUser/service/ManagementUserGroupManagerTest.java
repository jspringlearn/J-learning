package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.service.GenericTreeManagerTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/*
* @Author yyb
* @Date 2019/5/27 18:33
* @Version 1.0
* */
public class ManagementUserGroupManagerTest  extends GenericTreeManagerTestCase<Long, ManagementUserGroup,ManagementUserGroupManage> {
    public ManagementUserGroupManagerTest(Class<ManagementUserGroup> persistentClass) {
        super(persistentClass);
    }
    ManagementUserGroupManage managementUserGroupManage;

    @Autowired
    public void setManagementUserGroupManage(ManagementUserGroupManage managementUserGroupManage) {
        this.managementUserGroupManage = managementUserGroupManage;
        this.manager=this.managementUserGroupManage;
    }
    @Test
    public void test(){
        logger.debug("This is a test method for AOP");
        List<ManagementUserGroup> managementUserGroupList=new ArrayList<ManagementUserGroup>();
        for(int i=0;i<5;i++){
            ManagementUserGroup managementUserGroup=new ManagementUserGroup();
            managementUserGroupList.add(managementUserGroup);
        }
        this.managementUserGroupManage.save(managementUserGroupList);
    }
}
