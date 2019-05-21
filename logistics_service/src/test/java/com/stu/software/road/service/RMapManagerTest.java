package com.stu.software.road.service;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericTreeManagerTestCase;

public class RMapManagerTest extends GenericTreeManagerTestCase<Long, RMap, RMapManager> {


	private static final Logger logger = LogManager.getLogger(RMapManagerTest.class.getName());

	RMapManager rMapManager;
	
	public RMapManagerTest() {
		super(RMap.class);
	}

	public void setRMapManager(RMapManager rMapManager) {
		this.rMapManager=rMapManager;
		this.manager=this.rMapManager;
		List<RMap> result =this.rMapManager.findAll();
		if(logger.isInfoEnabled()) {
			logger.info("setRMapManager(RMapManager)-List<RMap> result={}",result);
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
