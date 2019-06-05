package com.stu.software.car.service;

import static junit.framework.TestCase.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.domain.Car;
import com.stu.software.service.GenericManagerTestCase;
/**
 * @author 宋明硕
 * @title
 * @Package com.stu.software
 * @date 2019/5/28 23:37
 */
public class CarManagerTest extends GenericManagerTestCase<Long, Car, CarManager> {

private static final Logger logger = LogManager.getLogger(CarManagerTest.class.getName());

	CarManager carManager;
	 public CarManagerTest() {
	        super(Car.class);
	    }
	@Autowired
	public void setCarManafer(CarManager carManafer) {
		this.carManager = carManafer;
		this.manager=this.carManager;
	}
	 @Test
	    public void testGetAll() {
	        List<Car> all=this.carManager.getAll();
	        //assertNotNull(all);

	        if (logger.isInfoEnabled()) {
	            logger.info("testGetAll() - List<Car> all={}", all); //$NON-NLS-1$
	        }
	    }


}
