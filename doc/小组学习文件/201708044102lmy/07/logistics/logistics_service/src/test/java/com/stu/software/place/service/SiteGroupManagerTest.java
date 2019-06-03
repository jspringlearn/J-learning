package com.stu.software.place.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import com.stu.software.place.domain.SiteGroup;
import com.stu.software.service.GenericTreeManagerTestCase;

public class SiteGroupManagerTest extends GenericTreeManagerTestCase<Long, SiteGroup, SiteGroupManager> {

	public SiteGroupManagerTest() {
		super(SiteGroup.class);
		// TODO Auto-generated constructor stub
	}

	SiteGroupManager siteGroupManager;
	
	public void setSiteGroupManager(SiteGroupManager siteGroupManager) {
		this.siteGroupManager = siteGroupManager;
		this.manager=this.siteGroupManager;
	}

	@Test
	public void test() {
		logger.debug("This is a test method for AOP");
        List<SiteGroup> siteGroupList = new ArrayList<SiteGroup>();
        for (int i = 0;i<4;i++) {
            SiteGroup siteGroup = new SiteGroup();
            siteGroupList.add(siteGroup);
        }
        this.siteGroupManager.save(siteGroupList);
	}

}
