package com.stu.software.ManagementUser.service.impl;

import com.stu.software.ManagementUser.dao.ManagementUserDao;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ManagementUserManagerImpl extends GenericManagerImpl<ManagementUser,Long> implements ManagementUserManage {


    ManagementUserDao managementUserDao;
    @Override
    public List<ManagementUser> findByManagementUserName(String ManagementName) {
        return null;
    }
    @Autowired
    public void setManagementUserDao(   ManagementUserDao managementUserDao){

        this.managementUserDao=managementUserDao;
        this.dao=this.managementUserDao;
    }
}
