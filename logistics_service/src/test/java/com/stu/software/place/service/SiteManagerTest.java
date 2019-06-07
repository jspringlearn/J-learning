package com.stu.software.place.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.place.domain.Site;
import com.stu.software.service.GenericManagerTestCase;

public class SiteManagerTest extends GenericManagerTestCase<Long, Site, SiteManager> {

private static final Logger logger = LogManager.getLogger(SiteManagerTest.class.getName());

	
	
	SiteManager siteManager;
	public SiteManagerTest() {
		super(Site.class);
	}



	@Autowired
	public void setSiteManafer(SiteManager siteManafer) {
		this.siteManager = siteManafer;
		this.manager=this.siteManager;
	}
	 @Test
	    public void testSave() {
	        logger.debug("This is a test method for AOP");
	        List<Site> siteList = new ArrayList<Site>();
	        for (int i = 0;i<10;i++) {
	            Site site = new Site();
	            site.setName("hello_"+i);
	            siteList.add(site);

	        }
	        this.siteManager.save(siteList);
	    }

}


