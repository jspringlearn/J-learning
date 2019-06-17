package com.stu.software.car.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.software.car.dao.CarDao;
import com.stu.software.car.domain.Car;
import com.stu.software.car.domain.CarBaseDao;
import com.stu.software.car.service.CarManager;

import com.stu.software.service.impl.GenericManagerImpl;

@Service("CarManager")
public class CarManagerImpl extends GenericManagerImpl<Car, Long> implements CarManager {
	private static final Logger logger = LogManager.getLogger(CarManagerImpl.class.getName());

	CarDao carDao;
	@Autowired
	public void setCarDao(CarDao carDao) {
		this.carDao=carDao;
		this.carDao=this.carDao;
	}
	@Override
	public void saveCar(String car_number,String car_volume,String car_owner,String car_status,String car_owner_tel,String car_road)
	{
		Car car=new Car();
		car.setCar_number(car_number);
		car.setCar_owner(car_owner);
		car.setCar_owner_tel(car_owner_tel);
		car.setCar_road(car_road);
		car.setCar_status(car_status);
		car.setCar_volume(car_volume);
		this.carDao.save(car);
	}
	
	
	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		List<Car> all = CarBaseDao.getintstan().findAll();
		return all;
	}
	@Override
	public void deleteCar(String car_number) {
		// TODO Auto-generated method stub
		CarBaseDao.getintstan().delete(car_number);
	}
	@Override
	public void update(Car car) {
		// TODO Auto-generated method stub
		CarBaseDao.getintstan().update(car);
	}
	@Override
	public Car search(String car_number) {
		// TODO Auto-generated method stub
		Car c=CarBaseDao.getintstan().search(car_number);
		System.out.println(c);
		return c;
	}



}
