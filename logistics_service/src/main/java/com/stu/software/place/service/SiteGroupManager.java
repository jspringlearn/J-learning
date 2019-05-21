package com.stu.software.place.service;

import java.util.List;

import com.stu.software.place.domain.SiteGroup;
import com.stu.software.service.GenericManager;

public interface SiteGroupManager extends GenericManager<SiteGroup, Long> {
	List<SiteGroup> findBySiteGroupName(String SiteGroupName);

}
