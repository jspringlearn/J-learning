package com.stu.software.Employee.dao;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StaffDaoTest extends GenericDaoTestCase<Long,Staff,StaffDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(StaffDaoTest.class.getName());

    @Autowired
    StaffDao staffDao;
    @Test
    public void testFindAll() {
        List<Staff> result = this.staffDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("testFindAll() - List<Staff> result={}", result); //$NON-NLS-1$
        }
    }
}
