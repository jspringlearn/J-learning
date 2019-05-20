package com.stu.software.service;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = { //"classpath:/applicationContext-resources.xml",
		"classpath:/applicationContext-dao.xml", "classpath:/applicationContext-service.xml"
          ,"classpath:/applicationContextTest-resources.xml"})
public class GenericGenerator extends AbstractJUnit4SpringContextTests {

}
