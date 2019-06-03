package com.stu.software.admin.service.impl;

import javax.transaction.Transactional;

import com.stu.software.admin.dao.UserDao;
import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.UserManager;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
@Transactional
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager {

    UserDao userDao;

    @Override
    public User findbyUsername(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
        this.dao = this.userDao;
    }

}
