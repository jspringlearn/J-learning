package com.stu.software.ManagementUser.service.impl;

import com.stu.software.ManagementUser.dao.ManagementUserDaoGroupDao;
import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.ManagementUser.service.ManagementUserGroupManage;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public class ManagementUserGroupManagerImpl extends GenericTreeManagerImpl<ManagementUserGroup,Long> implements ManagementUserGroupManage{

    ManagementUserDaoGroupDao managementUserDaoGroupDao;


    @Override
    public List<ManagementUserGroup> findByManagementUserGroupName(String ManagementUserGroup) {
        return null;
    }

    @Override
    public List<ManagementUserGroup> findByManagementUserGroupID(String ManagementUserGroup) {
        return null;
    }

    @Autowired
    public void setManagementUserDaoGroupDao(ManagementUserDaoGroupDao managementUserDaoGroupDao){
        this.managementUserDaoGroupDao=managementUserDaoGroupDao;
        this.treeDao=this.managementUserDaoGroupDao;
        this.dao=this.treeDao;
    }





}
