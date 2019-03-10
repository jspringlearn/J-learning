package edu.zut.cs.software.Demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration(locations= {"classpath:/applicationContextTest-service.xml"})  

public class DemoManagerTest extends AbstractTransactionalJUnit4SpringContextTests{

	DemoManagerimpi demoManager=new DemoManagerimpi();
	@Test
	public void test() {
		assertEquals(DemoManager.in,"Hello");
		String equ="hello",result=this.demoManager.sayHello("123");
		assertEquals(equ, result);
	}

}
