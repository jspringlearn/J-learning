package com.stu.software.admin.service;

import com.stu.software.admin.domain.User;
import com.stu.software.service.GenericManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

public class UserManagerTest extends GenericManagerTestCase<Long, User, UserManager> {
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
		this.userManager = userManager;
		this.manager = this.userManager;
	}

	@Test
	public void testSave() {
		logger.debug("This is a test method for AOP");
		List<User> userList = new ArrayList<User>();
		for (int i = 0;i<10;i++) {
			User user = new User();
			userList.add(user);
			
		}
		this.userManager.save(userList);
	}
	
}
