package com.at.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
 public static void main(String[] args) {
	/*HelloWorld helloworld =new HelloWorld();
	helloworld.setName("dwaddd");
	*/
	 ApplicationContext ctx =new ClassPathXmlApplicationContext("applicationContext.xml");
	 //HelloWorld helloworld =(HelloWorld)ctx.getBean("helloWorld");
	//helloworld.Hello();
}
}
