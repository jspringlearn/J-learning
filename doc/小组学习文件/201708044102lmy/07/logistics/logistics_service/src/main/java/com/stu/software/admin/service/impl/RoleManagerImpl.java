package com.stu.software.admin.service.impl;

import com.stu.software.admin.domain.Role;
import com.stu.software.admin.service.RoleManager;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.stereotype.Component;



@Component
public class RoleManagerImpl extends GenericManagerImpl<Role, Long> implements RoleManager {

}
