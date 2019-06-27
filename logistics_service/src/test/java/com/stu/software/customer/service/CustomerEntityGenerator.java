package com.stu.software.customer.service;

import com.stu.software.customer.domain.Customer;
import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerEntityGenerator extends GenericGenerator {

    @Autowired
    CustomerManage customerManage;

    @Autowired
    CustomerGroupManage customerGroupManage;

    @Test
    public void gen_ManagementUserGroup() {
        for (int i = 0; i < 3; i++) {
            CustomerGroup MUG = new CustomerGroup();
            MUG.setManagementName("ManagementName" + i);
            MUG.setCommonManagementName("CommonManagementName" + i);
            this.customerGroupManage.save(MUG);
            for (int j = 0; j < 5; j++) {
                CustomerGroup m = new CustomerGroup();
                m.setManagementName("ManagementName" + i + "_" + j);
                m.setCommonManagementName("CommonManagementName" + i + "_" + j);
                m.setManagementID("ManagementID" + i + j + j + j + j + j + j);
                m.setCommonManagementID("CommonManagementID" + i + i + j + j + j + j + j + j + j);
                m.setParent(MUG);
                MUG = this.customerGroupManage.save(m);
                this.gen_ManagementUser(MUG);
            }
        }
    }

    public void gen_ManagementUser(CustomerGroup customerGroup) {
        for (int i = 0; i < 3; i++) {
            Customer customer = new Customer();
            customer.setMName("Management" + i);
            customer.setMPhone("Management" + i + i + i + i + i + i);
            this.customerManage.save(customer);
        }
    }
}
