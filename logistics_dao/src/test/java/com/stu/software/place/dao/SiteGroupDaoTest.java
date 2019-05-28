package com.stu.software.place.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;
import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.place.domain.SiteGroup;


public class SiteGroupDaoTest  extends GenericTreeDaoTestCase<Long, SiteGroup, SiteGroupDao>{

	  private static final Logger logger = LogManager.getLogger(SiteGroupDaoTest.class.getName());

	    @Autowired
	    SiteGroupDao siteGroupDao;

	    @Test
	        public void testGetRoot() {
	           int n=2;
	            for(int i = 1; i <= n; i++) {
	            	SiteGroup siteGroup = new SiteGroup();
	            	siteGroup.setGroupName("siteGroup_" + i);
	            	siteGroup.setGroupName("siteGroup_" + i);
	                this.siteGroupDao.save(siteGroup);
	            }

	        List<SiteGroup> all = this.siteGroupDao.findAll();
	        if (logger.isInfoEnabled()) {
	            logger.info("test() - List<siteGroup> all size ={}", all.size()); //$NON-NLS-1$
	        }

	        }

}
