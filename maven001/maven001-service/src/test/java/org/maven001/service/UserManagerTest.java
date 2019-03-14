package org.maven001.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserManagerTest {
	UserManager usermanager;

	@Test
	public void testSayHello() {
		String expected = "Hello,world!";
		String result = this.usermanager.sayHello("world");
		assertEquals(expected,result);
		//fail("Not yet implemented");
	}	
	}
