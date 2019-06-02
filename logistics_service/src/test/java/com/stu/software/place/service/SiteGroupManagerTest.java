package com.stu.software.place.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.place.domain.SiteGroup;
import com.stu.software.service.GenericTreeManagerTestCase;

public class SiteGroupManagerTest extends GenericTreeManagerTestCase<Long, SiteGroup, SiteGroupManager> {

	private static final Logger logger = LogManager.getLogger(SiteGroupManagerTest.class.getName());
	public SiteGroupManagerTest() {
		super(SiteGroup.class);
		// TODO Auto-generated constructor stub
	}

	SiteGroupManager siteGroupManager;
	
	@Autowired
    public void setGroupManager(SiteGroupManager siteGroupManager) {
        this.siteGroupManager = siteGroupManager;
        this.manager = this.siteGroupManager;
        List<SiteGroup> result = this.siteGroupManager.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("setGroupManager(SiteGroupManager) - List<SiteGroup> result={}", result); //$NON-NLS-1$
		}
        
    }

}
