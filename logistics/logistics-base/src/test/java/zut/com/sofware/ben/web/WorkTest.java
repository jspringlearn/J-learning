package zut.com.sofware.ben.web;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zut.com.sofware.ben.Site;




public class WorkTest {

	@Test
	public void test() {
		ApplicationContext context=new ClassPathXmlApplicationContext("Sitebean.xml");
		
		
		Work work=context.getBean(Work.class);
		
		Site site=new Site();
		site.setName("河南省郑州市新郑市龙湖镇");
		site.setInfo("是一个美丽的地方");
		work.save(site);
	}


}
