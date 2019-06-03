package com.stu.software;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.employee.service.StaffManager;
import com.stu.software.service.GenericManagerTestCase;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software
 * @date 2019/5/20 15:59
 */
public class StaffManagerTest extends GenericManagerTestCase<Long, Staff, StaffManager> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(StaffManagerTest.class.getName());

    StaffManager staffManager;
    public StaffManagerTest() {
        super(Staff.class);
    }
    @Autowired
    public void setStaffManager(StaffManager staffManager) {
        this.staffManager=staffManager;
    }
    @Test
    public void testGetAll() {
        List<Staff> all=this.staffManager.getAll();
        assertNotNull(all);

        if (logger.isInfoEnabled()) {
            logger.info("testGetAll() - List<Staff> all={}", all); //$NON-NLS-1$
        }
    }
    @Test
    public void testSayHello() {
        String expected="Hello,world!";
        String result=this.staffManager.sayHello("world");

        if (logger.isInfoEnabled()) {
            logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
        }
       TestCase.assertEquals(expected,result);
    }
}
