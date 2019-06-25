package com.stu.software.ManagementUser.service.impl;

import com.stu.software.ManagementUser.dao.ManagementUserDao;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.domain.ManagementUser_CURD;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
    public ManagementUser findone1(int managementId) {
        ManagementUser managementUser=ManagementUser_CURD.getintstan().findOne(managementId);
        // System.out.println(goods);Site s=SiteBaseDao.getintstan().findOne(siteId);
        return managementUser;
    }

    @Override
    public List<ManagementUser> getAll() {
        return null;
    }

    @Override
    public List<ManagementUser> findBySno(int sno) {
        ManagementUser queryObject = new ManagementUser();
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        queryObject.setManagementID(sno);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("sno", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<ManagementUser> example = Example.of(queryObject, exampleMatcher);
        List<ManagementUser> result = this.dao.findAll(example);
        return result;
    }



    @Override
    public Boolean deleteById(Long id) {
        Optional<ManagementUser> managementUser = this.dao.findById(id);
        /**
         * Problem:
         * Judge is null
         * return false
         */
        if(managementUser.equals(null)) {
            return false;
        } else {
            this.dao.delete(managementUser.get());
            return true;
        }
    }

    @Override
    public Boolean deleteBySno(int sno) {
        List<ManagementUser> studentList = this.findBySno(sno);
        if(studentList.size() == 0) {
            return false;
        }
        else {
            for(int i = 0; i < studentList.size(); i++) {
                this.dao.delete(studentList.get(i));
            }
            return true;
        }
    }


}
