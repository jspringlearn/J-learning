package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.service.GenericTreeManager;

import java.util.List;

public interface ManagementUserGroupManage extends GenericTreeManager<ManagementUserGroup,Long> {

    /*
    * 根据管理员姓名查找
    * */
    List<ManagementUserGroup> findByManagementUserGroupName(String ManagementUserGroup);
    /*
    * 根据ID查找
    *
    * */
    List<ManagementUserGroup> findByManagementUserGroupID(String ManagementUserGroup);
}
