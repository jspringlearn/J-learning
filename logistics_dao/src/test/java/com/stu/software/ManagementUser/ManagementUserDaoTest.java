package com.stu.software.ManagementUser;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.ManagementUser.dao.ManagementUserDao;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.dao.GenericDaoTestCase;

public class ManagementUserDaoTest extends GenericDaoTestCase<Long, ManagementUser, ManagementUserDao> {

	private static final Logger logger = LogManager.getLogger(ManagementUserDaoTest.class.getName());
	@Autowired
	ManagementUserDao managementUserDao;
	
	@Test
	public void testFindAll() {
		List<ManagementUser> result = this.managementUserDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<ManagementUser> result={}", result); //$NON-NLS-1$
		}
	}


}
