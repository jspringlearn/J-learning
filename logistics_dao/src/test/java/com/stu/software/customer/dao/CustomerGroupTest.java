package com.stu.software.customer.dao;

import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.dao.GenericTreeDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerGroupTest extends GenericTreeDaoTestCase<Long, CustomerGroup, CustomerGroupDao> {

    @Autowired
    CustomerGroupDao customerGroupDao;

    @Test
    public void testGetRoot() {
        int n = 2;
        for (int i = 1; i <= n; i++) {
            CustomerGroup customerGroup = new CustomerGroup();

            customerGroup.setManagementName("ManagementName" + i + "号");
            customerGroup.setManagementID("ManagementID" + i);
            customerGroup.setCommonManagementName("CommonManagementName" + i + "号");
            customerGroup.setCommonManagementID("CommonManagementID" + i);
            this.customerGroupDao.save(customerGroup);
        }
    }
}
