package cn.gsonya.Practice.admin.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gsonya.Practice.admin.domain.User;
import cn.gsonya.Practice.base.service.GenericManagerTest;

public class UserManagerTest extends GenericManagerTest<Long, User, UserManager> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());

	UserManager userManager;
	public UserManagerTest() {
		super(User.class);
	}
	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager=userManager;
	}
	
	@Test
	public void testGetAll() {
		List<User>all=this.userManager.getAll();
		assertNotNull(all);

		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
	}
	@Test
	public void testSayHello() {
		String expected="Hello,world!";
		String result=this.userManager.sayHello("world");

		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}
		assertEquals(expected,result);
	}

}
