package edu.zut.cs.software.bean;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import edu.zut.cs.software.bean.UserManager;
@ContextConfiguration(locations = { "classpath:applicationContextTest-service.xml" })

public class ExeTestTest  extends AbstractJUnit4SpringContextTests{
	UserManager userManager;
	
	@Autowired
	public void setUserManager(UserManager userManager)
	{
		this.userManager=userManager;
	}

	@Test
	public void test() {
		String say="helloworld";
		assertEquals(say,this.userManager.say("world") );
		
	}

}
