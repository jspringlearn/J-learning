package com.stu.software.road.service;

import java.util.List;

import com.stu.software.road.domain.Circuit;
import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericTreeManager;



public interface RMapManager extends GenericTreeManager<RMap, Long> {

	List<RMap> findAll();
	RMap findByGroupName(String gName);
	List<Circuit> findBySite(String aSite,String bSite);
}
