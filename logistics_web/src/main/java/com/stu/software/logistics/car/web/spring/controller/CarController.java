package com.stu.software.logistics.car.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	
	/*
	 * @RequestMapping("/index") public String mainIndex(){ return "main/index"; }
	 */
	
	
	@RequestMapping("/showcar")
	// @RequestMapping(value = "/showcar", method = RequestMethod.POST)
	public String findAllCar(Model model)
	{
		List<Car> carList = this.carManager.findAll();
		/*
		 * for(Car car:carList) { System.out.println(car); }
		 */
		model.addAttribute("carList",carList);
		return "car/showcar";
	}
	
	
	@RequestMapping("/update")
	public String update(Car car)
	{
		System.out.println(car);
		this.carManager.update(car);
		return "forward:showcar.do";
	}
	
	
	@RequestMapping("/delete")
	public String delete(String car_number) {
		this.carManager.deleteCar(car_number);
		return "forward:showcar";
	}
	
	  @RequestMapping("/toupdatecar") 
	  public String toupdate(String car_number,Model model) { 
		  Car car=this.carManager.search(car_number);
		  model.addAttribute("car",car); 
		  return "car/update";
		  }
		  
	 

}















