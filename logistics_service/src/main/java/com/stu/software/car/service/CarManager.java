package com.stu.software.car.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.stu.software.car.domain.Car;
import com.stu.software.service.GenericManager;
@Component
@Transactional
public interface CarManager extends GenericManager<Car, Long> {

	
	void saveCar(String car_number,String car_volume,String car_owner,String car_status,String car_owner_tel,String car_road);
	void deleteCar(String car_number);
	void update(Car car);
	Car search(String car_number);

}
