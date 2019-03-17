package edu.zut.cs.software.admin.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })
public class UserManagerTest extends AbstractJUnit4SpringContextTests{
	
	UserManager usermanager;
	
	@Autowired
	void setusermanager(UserManager usermanager) {
		this.usermanager=usermanager;
	}

	@Test
	public void testSayHello() {
		String expected="Hello world!";
		String result=this.usermanager.sayHello("world");
		assertEquals(expected,result);
	}

}
