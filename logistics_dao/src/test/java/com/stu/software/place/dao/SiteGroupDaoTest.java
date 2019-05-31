package com.stu.software.place.dao;

import static org.junit.Assert.assertEquals;

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

	    
	    SiteGroupDao siteGroupDao;


	    @Autowired
		public void setSiteGroupDao(SiteGroupDao siteGroupDao) {
			this.siteGroupDao = siteGroupDao;
			this.dao=this.siteGroupDao;
		}

		//	    @Test
//	        public void testGetRoot() {
//	           int n=2;
//	            for(int i = 1; i <= n; i++) {
//	            	SiteGroup siteGroup = new SiteGroup();
//	            	siteGroup.setGroupName("siteGroup_" + i);
//	            	siteGroup.setGroupName("siteGroup_" + i);
//	                this.siteGroupDao.save(siteGroup);
//	            }
//
//	        List<SiteGroup> all = this.siteGroupDao.findAll();
//	        if (logger.isInfoEnabled()) {
//	            logger.info("test() - List<siteGroup> all size ={}", all.size()); //$NON-NLS-1$
//	        }
//
//	        }
	    @Test
	    public void testGetRoot() {
			int root_size = 10;
			for (int i = 0; i < root_size; i++) {
				SiteGroup group = new SiteGroup();
				group.setGroupName("group_" + i);
				for (int j = 0; j < 10; j++) {
					SiteGroup g = new SiteGroup();
					g.setGroupName("group_" + i + "_" + j);
					g.setParent(group);
				}
				this.siteGroupDao.save(group);
			}

			List<SiteGroup> roots = this.siteGroupDao.getRoot();
			assertEquals(root_size, roots.size());

			if (logger.isInfoEnabled()) {
				logger.info("testGetRoot() - List<Group> roots=" + roots); //$NON-NLS-1$
			}
		}

}
