package com.stu.software.ManagementUser.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.dao.GenericDao;

@Repository("managementUserDao")
public interface ManagementUserDao extends GenericDao<ManagementUser, Long> {

}
