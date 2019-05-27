package com.stu.software.car.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.domain.Car;
import com.stu.software.place.service.SiteManagerTest;
import com.stu.software.service.GenericManagerTestCase;

public class CarManagerTest extends GenericManagerTestCase<Long, Car, CarManager> {
private static final Logger logger = LogManager.getLogger(SiteManagerTest.class.getName());

	
	public CarManagerTest(Class<Car> persistentClass) {
		super(persistentClass);
	}
	CarManager carManager;



	@Autowired
	public void setCarManafer(CarManager carManafer) {
		this.carManager = carManafer;
		this.manager=this.carManager;
	}
	 @Test
	    public void testSave() {
	        logger.debug("This is a test method for AOP");
	        List<Car> carList = new ArrayList<Car>();
	        for (int i = 0;i<10;i++) {
	            Car car = new Car();
	            carList.add(car);

	        }
	        this.carManager.save(carList);
	    }


}
