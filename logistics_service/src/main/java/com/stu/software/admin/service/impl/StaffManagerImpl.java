package com.stu.software.admin.service.impl;

import com.stu.software.Employee.dao.StaffDao;
import com.stu.software.Employee.domain.Staff;
import com.stu.software.admin.service.StaffManager;
import com.stu.software.service.impl.GenericManagerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.admin.service.impl
 * @date 2019/5/20 15:50
 */
@Service("StaffManager")
public class StaffManagerImpl extends GenericManagerImpl<Staff, Long> implements StaffManager {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(StaffManagerImpl.class.getName());

    StaffDao staffDao;
    @Autowired
    public void setStaffDao(StaffDao staffDao) {
        this.staffDao=staffDao;
        this.dao=this.staffDao;
    }
    @Override
    public String sayHello(String name) {
        String result="Hello,"+name+"!";

        if (logger.isInfoEnabled()) {
            logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
        }
        return result;
    }
    @Override
    public List<Staff> getAll(){
        List<Staff>all=this.staffDao.findAll();

        if (logger.isInfoEnabled()) {
            logger.info("getAll() - List<Staff> all={}", all); //$NON-NLS-1$
        }
        return all;
    }

}
