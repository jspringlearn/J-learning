package service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ExeTestTest  {
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
