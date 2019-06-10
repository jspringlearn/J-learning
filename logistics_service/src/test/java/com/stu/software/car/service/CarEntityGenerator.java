package com.stu.software.car.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.car.domain.Car;
import com.stu.software.car.domain.Garage;
import com.stu.software.service.GenericGenerator;

public class CarEntityGenerator extends GenericGenerator {
	@Autowired
	CarManager carManager;
	@Autowired
	GarageManager garageManager;
	@Test
	public void gen_carGroup() {
		for (int i = 0; i < 10; i++) {
            Garage s = new Garage();
            s.setName("Garage" + i);
            this.garageManager.save(s);
            for (int j = 0; j < 10; j++) {
                Garage garage = new Garage();
                garage.setGarageName("Garage_" + i + "_" + j);
                garage.setParent(s);
                s = this.garageManager.save(garage);
                this.gen_car(s);
            }
        }
		
	}
	public void gen_car(Garage s) {
		for(int i=0;i<10;i++) {
			Car car=new Car();
			car.setName("carname_"+i);
			car.setInfo("siteInfo_"+i);
			car.setGroup(s);
			this.carManager.save(car);
		}
		
	}


}
