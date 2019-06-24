package com.stu.software.logistics.car.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.stu.software.car.domain.Car;
import com.stu.software.car.service.CarManager;
import com.stu.software.order.domain.Order;
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

	//show all car
//	@RequestMapping("/showcar")
//	// @RequestMapping(value = "/showcar", method = RequestMethod.POST)
//	public String findAllCar(Model model)
//	{
//		List<Car> carList = this.carManager.findAll();
//		/*
//		 * for(Car car:carList) { System.out.println(car); }
//		 */
//		model.addAttribute("carList",carList);
//		return "car/showcar";
//	}


	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Car> findAllUser(){
		return this.manager.findAll();
	}




	
	//modify car besides car_number
	@RequestMapping("/update")
	public String update(Car car)
	{
		System.out.println(car);
		this.carManager.update(car);
		return "forward:showcar.do";
	}
	
	//delete car
	@RequestMapping("/delete")
	public String delete(String car_number) {
		this.carManager.deleteCar(car_number);
		return "forward:showcar";
	}
	
	
	//update car information
	  @RequestMapping("/toupdatecar") 
	  public String toupdate(String car_number,Model model) { 
		  Car car=this.carManager.search(car_number);
		  model.addAttribute("car",car); 
		  return "car/update";
		  }
	  
	  //add a car
	  @RequestMapping("/toadd")
	    public String addCar(){
	        return "car/addcar";
	    }
	    @RequestMapping("/addcar")
	    public String Addorder(Car car){
	       this.carManager.save(car);
	        return "forward:showcar";
	    }

		  
	 

}















