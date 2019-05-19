package com.stu.software.road.dao;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;

import com.stu.software.road.domain.Circuit;

public class CircuitDaoTest extends GenericDaoTestCase<Long, Circuit,CircuitDao > {

	private static final Logger logger = LogManager.getLogger(CircuitDaoTest.class.getName());
	@Autowired
	CircuitDao circuitDao;
	@Test
	public void testFindAll() {
		List<Circuit> result=this.circuitDao.findAll();
		if(logger.isInfoEnabled())
		{
			logger.info("testFindAll() - List<Circuit> result={}", result);
		}
	}

}
