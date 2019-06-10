package com.stu.software.ManagementUser.dao;


import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("managementUserDaoGroupDao")
public interface ManagementUserDaoGroupDao extends GenericTreeDao<ManagementUserGroup, Long> {
}
