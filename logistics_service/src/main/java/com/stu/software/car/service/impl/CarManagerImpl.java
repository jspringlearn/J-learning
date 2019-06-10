package com.stu.software.car.service.impl;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.stereotype.Service;

import com.stu.software.car.domain.Car;
import com.stu.software.car.service.CarManager;

import com.stu.software.service.impl.GenericManagerImpl;

@Service("CarManager")
public class CarManagerImpl extends GenericManagerImpl<Car, Long> implements CarManager {
	private static final Logger logger = LogManager.getLogger(CarManagerImpl.class.getName());

	@Override
	public List<Car> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
