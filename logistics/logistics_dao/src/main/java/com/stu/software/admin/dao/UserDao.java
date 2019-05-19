package com.stu.software.admin.dao;


import com.stu.software.admin.domain.User;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDao extends GenericDao<User, Long> {

}
