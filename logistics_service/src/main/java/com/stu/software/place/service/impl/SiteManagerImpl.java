package com.stu.software.place.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stu.software.place.dao.SiteDao;
import com.stu.software.place.domain.Site;
import com.stu.software.place.service.SiteManager;
import com.stu.software.service.impl.GenericManagerImpl;

@Component
public class SiteManagerImpl extends GenericManagerImpl<Site, Long> implements SiteManager {

	SiteDao siteDao;
	@Override
	public List<Site> findBySite(String SiteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> findBySiteName(String SiteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> findBySiteInfo(String SiteInfo) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Autowired
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao=siteDao;
		this.dao=this.siteDao;
		
	}
	@Override
	public void savesite() {
		// TODO Auto-generated method stub
		int n=2;
        for(int i = 1; i <= n; i++) {
            Site site = new Site();
            site.setName("site_" + i);
            this.siteDao.save(site);
        }
		
	}

	@Override
	public List<Site> findallsite() {
		// TODO Auto-generated method stub
		List<Site> all = this.siteDao.findAll();
		for(Object o:all) {
			o.toString();
		}
		return null;
	}


}
