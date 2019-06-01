package com.stu.software.road.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericTreeManagerTestCase;

public class RMapManagerTest extends GenericTreeManagerTestCase<Long, RMap, RMapManager> {


	private static final Logger logger = LogManager.getLogger(RMapManagerTest.class.getName());

	
	RMapManager rMapManager;
	
	public RMapManagerTest() {
		super(RMap.class);
	}
	@Autowired
	public void setRMapManager(RMapManager rMapManager) {
		this.rMapManager=rMapManager;
		this.manager=this.rMapManager;
		List<RMap> result =this.rMapManager.findAll();
		if(logger.isInfoEnabled()) {
			logger.info("setRMapManager(RMapManager)-List<RMap> result={}",result);
		}
	}

	@Test
	public void testSave() {
		logger.debug("This is a test method for AOP");
		List<RMap> rmList=new ArrayList<RMap>();
		for(int i=0;i<4;i++) {
			RMap rMap=new RMap();
			rmList.add(rMap);
		}
		this.rMapManager.save(rmList);
	}

}
