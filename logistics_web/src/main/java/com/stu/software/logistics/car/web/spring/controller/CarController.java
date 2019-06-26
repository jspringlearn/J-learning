package com.stu.software.logistics.car.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.car.domain.Car;
import com.stu.software.car.service.CarManager;
import com.stu.software.goods.domain.Goods;
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
	public List<Car> findAllCar(){
		return this.carManager.findAll();
	}




	
	//modify car besides car_number
	@RequestMapping("/update")
	public String update(Car car)
	{
		this.carManager.update(car);
		return "forward:showcar.do";
	}
	
	
	/*临时注释测试
	//delete car
	@RequestMapping(value = "/deleteCar/{car_number}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
	public @ResponseBody Car deleteCar(@PathVariable(value ="car_number") String car_number) {
        Car car=carManager.search(car_number);
        this.carManager.deleteCar(car_number);
        return car;
    }
	
	
	
	//save(add)
	 @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	    public @ResponseBody Car save(Car car) {
	        this.carManager.save(car);
	      return car;
	    }
	*/
	
	
	
/*
	
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

		  */
	 

	 @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
	    public  @ResponseBody
	    Car deleteone(@PathVariable(value = "id") Long id){
	        Car car=carManager.findById(id);
	        this.carManager.delete(id);
	        return car;
	    }

	    @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	    public @ResponseBody Car save(Car car){
	        this.carManager.save(car);
	        return car;
	    }

	 
	 
}















