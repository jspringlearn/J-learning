package org.maven001.service;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserManagerTest {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerTest.class.getName());

	UserManager usermanager = new UserManager();

	@Test
	public void testSayHello() {
		String expected = "Hello,world!";
		String result = this.usermanager.sayHello("world");
		if (logger.isInfoEnabled()) {
			logger.info("testSayHello() - String result={}", result); //$NON-NLS-1$
		}

		assertEquals(expected,result);
		//fail("Not yet implemented");
	}	
	}
