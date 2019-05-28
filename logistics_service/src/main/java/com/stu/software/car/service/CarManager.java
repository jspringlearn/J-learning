package com.stu.software.car.service;

import java.util.List;


import com.stu.software.car.domain.Car;
import com.stu.software.service.GenericManager;

public interface CarManager extends GenericManager<Car, Long> {

	List<Car> getAll();


}
