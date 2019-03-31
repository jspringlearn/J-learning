package edu.zut.cs.software.ZExe.admin.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.ZExe.admin.entity.User;


@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })
public class UserManagerTest extends AbstractJUnit4SpringContextTests {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());

	UserManager userManager;

	@Autowired
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	@Test
	public void testSayHello() {
		String expected = "Hello, world!";
		String result = this.userManager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected, result);
	}
	 @Test
	public void testGetAll() {
		List<User> all = this.userManager.getAll();
       // assertNotNull(all);
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		
	}

}
