package com.stu.software.customer.service;

import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.service.GenericTreeManager;
import org.springframework.stereotype.Component;

@Component
public interface CustomerGroupManage extends GenericTreeManager<CustomerGroup, Long> {

    /*
     * 根据管理员姓名查找
     * */
    // List<CustomerGroup> findByManagementUserGroupName(String CustomerGroup);
    /*
     * 根据ID查找
     *
     * */
    // List<CustomerGroup> findByManagementUserGroupID(String CustomerGroup);
}
