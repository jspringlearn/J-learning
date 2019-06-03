package com.stu.software.place.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;
import com.stu.software.place.domain.Site;

public class SiteDaoTest extends GenericDaoTestCase<Long, Site, SiteDao> {

	  private static final Logger logger = LogManager.getLogger(SiteDaoTest.class.getName());

	    @Autowired
	    SiteDao siteDao;

	    @Test
	        public void testGetRoot() {
	           int n=2;
	            for(int i = 1; i <= n; i++) {
	                Site site = new Site();
	                site.setName("site_" + i);
	                site.setName("site_" + i);
	                this.siteDao.save(site);
	            }

	        List<Site> all = this.siteDao.findAll();
	        if (logger.isInfoEnabled()) {
	            logger.info("test() - List<site> all size ={}", all.size()); //$NON-NLS-1$
	        }

	        }

}
