package com.stu.software.road.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.road.domain.RMap;

public class RMapDaoTest extends GenericTreeDaoTestCase<Long, RMap, RMapDao> {


	private static final Logger logger=LogManager.getLogger(RMapDaoTest.class);
	RMapDao rMapDao;
	@Autowired
	public void setRMapDao(RMapDao rMapDao) {
		this.rMapDao=rMapDao;
		this.dao=this.rMapDao;
	}
	@Test
	public void testGetRoot() {
		int size  =4;
		for(int i=0;i< size;i++) {
			RMap rMap =new RMap();
			rMap.setCircuitName("RMap_"+i);
			for(int j=0;j<10;j++) {
				RMap r=new RMap();
				r.setCircuitName("RMap_"+i+"_"+j);
				r.setParent(rMap);
			}
			this.rMapDao.save(rMap);
		}
		List<RMap> roots =this.rMapDao.getRoot();
		assertEquals(size, roots.size());
		if(logger.isInfoEnabled()) {
			logger.info("testGetRoot() - List<RMap> roots=" + roots);
		}
	}

}
