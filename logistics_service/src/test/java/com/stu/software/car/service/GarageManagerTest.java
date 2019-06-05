package com.stu.software.car.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.domain.Garage;

import com.stu.software.service.GenericTreeManagerTestCase;

public class GarageManagerTest extends GenericTreeManagerTestCase<Long, Garage, GarageManager> {
	
	GarageManager garageManager;
	 public GarageManagerTest() {
	        super(Garage.class);
	    }
	    @Autowired
	    public void setGarageManager(GarageManager garageManager) {
	        this.garageManager=garageManager;
	        this.manager=this.garageManager;
	    }
	    
	@Test
	public void test() {
		logger.debug("This is a test method for AOP");
        List<Garage> garageList = new ArrayList<Garage>();
        for (int i = 0;i<4;i++) {
        	Garage garage = new Garage();
        	garageList.add(garage);
        }
        this.garageManager.save(garageList);
	}


}
