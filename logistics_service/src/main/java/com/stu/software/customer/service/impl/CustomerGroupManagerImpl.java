package com.stu.software.customer.service.impl;

import com.stu.software.customer.dao.CustomerGroupDao;
import com.stu.software.customer.domain.CustomerGroup;
import com.stu.software.customer.service.CustomerGroupManage;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("ManagementUserGroupManager")
@Transactional
public class CustomerGroupManagerImpl extends GenericTreeManagerImpl<CustomerGroup, Long> implements CustomerGroupManage {

    CustomerGroupDao customerGroupDao;


    @Autowired
    public void setCustomerGroupDao(CustomerGroupDao customerGroupDao) {
        this.customerGroupDao = customerGroupDao;
        this.treeDao = this.customerGroupDao;
        this.dao = this.treeDao;
    }


}
