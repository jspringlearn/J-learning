package com.stu.software.road.service;

import java.util.Date;
import java.util.List;

import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericTreeManager;



public interface RMapManager extends GenericTreeManager<RMap, Long> {

	List<RMap> findAllCircuit(int beginSiteID,int endSiteID);
	double getAllDistance( );
	Date getAllTime();
	int getAllMoney();
}
