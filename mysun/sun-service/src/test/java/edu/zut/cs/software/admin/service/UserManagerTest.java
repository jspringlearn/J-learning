package edu.zut.cs.software.admin.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.admin.entity.User;

@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })
public class UserManagerTest extends AbstractJUnit4SpringContextTests{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());
	
	UserManager usermanager;
	
	@Autowired
	void setusermanager(UserManager usermanager) {
		this.usermanager=usermanager;
	}

	@Test
	public void testSayHello() {
		String expected="Hello world!";
		String result=this.usermanager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected,result);
	}
	@Test
	public void testGetAll() {
		List<User>all=this.usermanager.getAll();
		if (logger.isInfoEnabled()) {
			logger.info("testGetAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		
	}
	

}
