package com.stu.software.customer.dao;

import com.stu.software.customer.domain.Customer;
import com.stu.software.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerDaoTest extends GenericDaoTestCase<Long, Customer, CustomerDao> {

    private static final Logger logger = LogManager.getLogger(CustomerDaoTest.class.getName());
    @Autowired
    CustomerDao customerDao;

    @Test

    public void testGetRoot() {
        int n = 2;
        for (int i = 1; i <= n; i++) {
            Customer ma = new Customer();
            ma.setMName("Management" + i);
            ma.setMPhone("Management" + i + i + i + i + i + i);
            this.customerDao.save(ma);
        }
    }

    public void testFindAll() {
        List<Customer> result = this.customerDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Customer> result={}", result); //$NON-NLS-1$
        }
    }


}
