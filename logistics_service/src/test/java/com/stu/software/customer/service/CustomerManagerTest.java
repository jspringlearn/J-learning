package com.stu.software.customer.service;

import com.stu.software.customer.domain.Customer;
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
public class CustomerManagerTest extends GenericManagerTestCase<Long, Customer, CustomerManage> {

    private static final Logger logger = LogManager.getLogger(CustomerManagerTest.class.getName());
    CustomerManage customerManage;


    public CustomerManagerTest() {
        super(Customer.class);
    }

    @Autowired
    public void setCustomerManage(CustomerManage customerManage) {
        this.customerManage = customerManage;
        this.manager = this.customerManage;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
//        for(int i=0;i<5;i++) {
//            Customer managementUser = new Customer();
//            managementUser.setMName("MU"+i);
//            managementUser=this.managementUserManage.save(managementUser);
//            for(int j=0;j<5;j++){
//                Customer managementUser1 = new Customer();
//                managementUser1.setMName("MU1"+j);
//                managementUser1.setParent(managementUser);
//            }
//        }
        List<Customer> customerList = new ArrayList<Customer>();
        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customerList.add(customer);
        }
        this.customerManage.save(customerList);
    }
}
