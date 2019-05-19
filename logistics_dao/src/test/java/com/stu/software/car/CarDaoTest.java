package com.stu.software.car;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.dao.CarDao;
import com.stu.software.car.domain.Car;
import com.stu.software.dao.GenericDaoTestCase;

public class CarDaoTest extends GenericDaoTestCase<Long, Car, CarDao> {

	private static final Logger logger = LogManager.getLogger(CarDaoTest.class.getName());

	@Autowired
	CarDao carDao;

	@Test
	public void testFindAll() {
		List<Car> result = this.carDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("testFindAll() - List<User> result={}", result); //$NON-NLS-1$
		}

	}

}
