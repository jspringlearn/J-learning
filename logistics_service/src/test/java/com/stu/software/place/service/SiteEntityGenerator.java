package com.stu.software.place.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.place.domain.Site;
import com.stu.software.place.domain.SiteGroup;
import com.stu.software.service.GenericGenerator;


public class SiteEntityGenerator extends GenericGenerator {
	@Autowired
	SiteManager siteManager;
	@Autowired
	SiteGroupManager siteGroupManager;
	
	
	@Test
	public void gen_siteGroup() {
		for (int i = 0; i < 10; i++) {
            SiteGroup s = new SiteGroup();
            s.setGroupName("siteGroup_" + i);
            this.siteGroupManager.save(s);
            for (int j = 0; j < 10; j++) {
                SiteGroup group = new SiteGroup();
                group.setGroupName("siteGroup_" + i + "_" + j);
                group.setParent(s);
                s = this.siteGroupManager.save(group);
                this.gen_site(s);
            }
        }
		
	}
	public void gen_site(SiteGroup s) {
		for(int i=0;i<10;i++) {
			Site site=new Site();
			site.setName("sitename_"+i);
			site.setInfo("siteInfo_"+i);
			site.setGroup(s);
			this.siteManager.save(site);
		}
		
	}

}
