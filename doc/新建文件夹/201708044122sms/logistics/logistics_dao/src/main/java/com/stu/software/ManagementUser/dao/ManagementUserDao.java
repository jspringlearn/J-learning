package com.stu.software.ManagementUser.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.dao.GenericTreeDao;

@Repository("managementUserDao")
public interface ManagementUserDao extends GenericTreeDao<ManagementUser, Long> {

}
