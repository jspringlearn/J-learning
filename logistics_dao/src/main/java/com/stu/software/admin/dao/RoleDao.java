package com.stu.software.admin.dao;


import com.stu.software.admin.domain.Role;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("roleDao")
public interface RoleDao extends GenericDao<Role, Long> {

}
