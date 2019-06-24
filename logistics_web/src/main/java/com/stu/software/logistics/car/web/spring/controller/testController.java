package com.stu.software.logistics.car.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.software.car.domain.Car;
import com.stu.software.car.service.CarManager;
import com.stu.software.web.spring.controller.GenericController;

public class testController extends GenericController<Car, Long, CarManager> {


@Controller
@RequestMapping("/car")
public class CarController extends GenericController<Car, Long, CarManager> {
	CarManager carManager;
	@Autowired
	public void setCarManager(CarManager carManager) {
		this.carManager = carManager;
		this.manager = this.carManager;
	}
	
	@RequestMapping("/index")
    public String mainIndex(){
        return "main/index";
    }
	
		/*
		 * @RequestMapping("/test")
		 * 
		 * public String findAllCar(Model model) { List<Car> carList =
		 * this.carManager.findAll(); model.addAttribute("carList",carList); return
		 * "car/test"; }
		 */
}
}
