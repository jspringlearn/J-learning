package com.stu.software.place.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stu.software.place.dao.SiteDao;
import com.stu.software.place.domain.Site;
import com.stu.software.place.service.SiteManager;
import com.stu.software.service.impl.GenericManagerImpl;
import com.stu.software.zbase.SiteBaseDao;

@Component
public class SiteManagerImpl extends GenericManagerImpl<Site, Long> implements SiteManager {

	SiteDao siteDao;   
	@Autowired
	public void setSiteDao(SiteDao siteDao) {
		this.siteDao=siteDao;
		this.dao=this.siteDao;
		
	}
	@Override
	public void savesite(String name,String info) {
		// TODO Auto-generated method stub
            Site site = new Site();
            site.setName(name);
            site.setInfo(info);
            this.siteDao.save(site);		
	}

	@Override
	public List<Site> findallsite() {
		// TODO Auto-generated method stub
		List<Site> all = SiteBaseDao.getintstan().findAll();
		return all;
	}


}
