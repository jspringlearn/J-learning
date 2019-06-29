package com.stu.software.customer.dao;

import com.stu.software.customer.domain.Customer;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("customerDao")
public interface CustomerDao extends GenericDao<Customer, Long> {

}
