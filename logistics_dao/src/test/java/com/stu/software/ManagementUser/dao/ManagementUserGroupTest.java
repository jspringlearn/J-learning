package com.stu.software.ManagementUser.dao;

import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.dao.GenericDaoTestCase;
import com.stu.software.dao.GenericTreeDaoTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagementUserGroupTest extends GenericTreeDaoTestCase<Long, ManagementUserGroup,ManagementUserDaoGroupDao > {

    @Autowired
    ManagementUserDaoGroupDao managementUserDaoGroupDao;
    @Test
    public void testGetRoot() {
        int n=2;
        for(int i = 1; i <= n; i++)
        {
            ManagementUserGroup managementUserGroup=new  ManagementUserGroup();

            managementUserGroup.setManagementName("ManagementName"+i+"号");
            managementUserGroup.setManagementID("ManagementID"+i);
            managementUserGroup.setCommonManagementName("CommonManagementName" +i+"号");
            managementUserGroup.setCommonManagementID("CommonManagementID"+i);
            this.managementUserDaoGroupDao.save(managementUserGroup);
        }
    }
}
