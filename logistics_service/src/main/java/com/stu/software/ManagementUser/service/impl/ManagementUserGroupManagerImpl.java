package com.stu.software.ManagementUser.service.impl;

import com.stu.software.ManagementUser.dao.ManagementUserDaoGroupDao;
import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.ManagementUser.service.ManagementUserGroupManage;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("ManagementUserGroupManager")
@Transactional
public class ManagementUserGroupManagerImpl extends GenericTreeManagerImpl<ManagementUserGroup,Long> implements ManagementUserGroupManage{

    ManagementUserDaoGroupDao managementUserDaoGroupDao;




    @Autowired
    public void setManagementUserDaoGroupDao(ManagementUserDaoGroupDao managementUserDaoGroupDao){
        this.managementUserDaoGroupDao=managementUserDaoGroupDao;
        this.treeDao=this.managementUserDaoGroupDao;
        this.dao=this.treeDao;
    }





}
