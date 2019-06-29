package com.stu.software.customer.service;

import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CustomerGroupManagerTest extends GenericTreeManagerTestCase<Long, CustomerGroup, CustomerGroupManager> {
    private static final Logger logger = LogManager.getLogger(CustomerManagerTest.class.getName());
    CustomerGroupManager customerGroupManager;


    public CustomerGroupManagerTest() {
        super(CustomerGroup.class);
    }

    @Autowired
    public void setCustomerGroupManager(CustomerGroupManager customerGroupManager) {
        this.customerGroupManager = customerGroupManager;
        this.manager = this.customerGroupManager;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<CustomerGroup> storeList = new ArrayList<CustomerGroup>();
        for (int i = 0; i < 4; i++) {
            CustomerGroup store = new CustomerGroup();
            storeList.add(store);
        }
        this.customerGroupManager.save(storeList);
    }
}
