package com.stu.software.ManagementUser.service.impl;

import com.stu.software.ManagementUser.dao.ManagementUserDao;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.domain.ManagementUser_CURD;
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

    @Autowired
    public void setManagementUserDao(   ManagementUserDao managementUserDao){

        this.managementUserDao=managementUserDao;
        this.dao=this.managementUserDao;
    }
    @Override
    public List<ManagementUser> findByManagementUserName(String ManagementName) {
        return null;
    }

    @Override
    public void savemanagementUser(String name, String phone) {
        ManagementUser managementUser=new ManagementUser();
        managementUser.setMName(name);
        managementUser.setMPhone(phone);
        this.managementUserDao.save(managementUser);
    }

    @Override
    public void deletemanagementUser(int managementUserId) {
        ManagementUser_CURD.getintstan().del(managementUserId);
    }


    @Override
    public void upd(ManagementUser managementUser) {
        ManagementUser_CURD .getintstan().upd(managementUser);

    }

    @Override
    public ManagementUser findone(int managementId) {
        ManagementUser managementUser=new ManagementUser();
        managementUser=ManagementUser_CURD.getintstan().findOne(managementId);
        // System.out.println(goods);
        return managementUser;
    }



}
