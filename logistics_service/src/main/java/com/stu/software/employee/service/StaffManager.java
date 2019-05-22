package com.stu.software.employee.service;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.service.GenericManager;

import java.util.List;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.admin.service
 * @date 2019/5/20 15:49
 */
public interface StaffManager extends GenericManager<Staff,Long> {
    String sayHello(String name);
    List<Staff> getAll();
}
