package service;

import static org.junit.Assert.*;

import org.junit.Test;
<<<<<<< HEAD
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
=======

public class ExeTestTest {

	@Test
	public void test() {
		String say="hello";
		assertEquals(say, ExeTest.str);
>>>>>>> 9fd6eed027141f5efe4a2cd5618a29dd2e458e52
		
	}

}
