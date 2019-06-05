package com.stu.software.Employee.dao;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("staffDao")
public interface StaffDao extends GenericDao<Staff,Long> {
}
