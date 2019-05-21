package com.stu.software.place.service;

import java.util.List;

import com.stu.software.place.domain.Site;
import com.stu.software.service.GenericManager;

public interface SiteManager extends GenericManager<Site, Long> {
	List<Site> findBySite(String SiteId);
	List<Site> findBySiteName(String SiteName);
	List<Site> findBySiteInfo(String SiteInfo);
	

}
