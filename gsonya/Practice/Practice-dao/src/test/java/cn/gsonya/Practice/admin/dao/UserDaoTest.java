package cn.gsonya.Practice.admin.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gsonya.Practice.admin.domain.User;
import cn.gsonya.Practice.base.dao.GenericDaoTest;

public class UserDaoTest extends GenericDaoTest<Long, User, UserDao> {

	private static final Logger logger=LogManager.getLogger(UserDaoTest.class.getName());
	@Autowired
	UserDao userDao;
	@Test
	public void testFindAll() {
		List<User>result=this.userDao.findAll();

		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<User> result={}", result); //$NON-NLS-1$
		}
	}

}
