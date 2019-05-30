package com.stu.software.logistics.car.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.software.car.domain.Car;
import com.stu.software.car.service.CarManager;
import com.stu.software.web.spring.controller.GenericController;


@Controller
@RequestMapping("/car")
public class CarController extends GenericController<Car, Long, CarManager> {
	CarManager carManager;

    @Autowired
    public void setCarManager(CarManager carManager) {
        this.carManager = carManager;
        this.manager = this.carManager;
    }

}
