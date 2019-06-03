package com.stu.software.place.service;

import java.util.List;

import com.stu.software.place.domain.SiteGroup;
import com.stu.software.service.GenericManager;
import com.stu.software.service.GenericTreeManager;

public interface SiteGroupManager extends GenericTreeManager<SiteGroup, Long> {
	
	List<SiteGroup> findBySiteGroupName(String SiteGroupName);

}
