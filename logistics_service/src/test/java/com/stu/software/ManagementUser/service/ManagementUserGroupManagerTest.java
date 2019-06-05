package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ManagementUserGroupManagerTest extends GenericTreeManagerTestCase<Long, ManagementUserGroup,ManagementUserGroupManage> {
    private static final Logger logger = LogManager.getLogger(ManagementUserManagerTest.class.getName());
    public ManagementUserGroupManagerTest() {
        super(ManagementUserGroup.class);
    }


    ManagementUserGroupManage managementUserGroupManage;
    @Autowired
    public void setManagementUserGroupManage(ManagementUserGroupManage managementUserGroupManage) {
        this.managementUserGroupManage = managementUserGroupManage;
        this.manager=this.managementUserGroupManage;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<ManagementUserGroup> storeList = new ArrayList<ManagementUserGroup>();
        for (int i = 0;i<4;i++) {
            ManagementUserGroup store = new ManagementUserGroup();
            storeList.add(store);
        }
        this.managementUserGroupManage.save(storeList);
    }
}
