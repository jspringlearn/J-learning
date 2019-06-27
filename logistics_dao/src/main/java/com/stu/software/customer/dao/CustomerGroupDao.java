package com.stu.software.customer.dao;


import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("managementUserDaoGroupDao")
public interface CustomerGroupDao extends GenericTreeDao<CustomerGroup, Long> {
}
