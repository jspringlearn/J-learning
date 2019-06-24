package com.stu.software.logistics.order.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.stu.software.order.domain.Order;
import com.stu.software.order.service.OrderManager;
import com.stu.software.web.spring.controller.GenericController;




@Controller
@RequestMapping("/order")
public class OrdeController extends GenericController<Order,Long, OrderManager> {

	
	OrderManager orderManager;
	@Autowired
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
		this.manager=this.orderManager;
	}
	/**
	 *  test
	 * @return
	 */
	@RequestMapping("/index")
	public String mainIndex(){
		return "main/index";
	}
	
	/**
	 *  findorder
	 * 
	 */
//	@RequestMapping("/findorder")    //  /allsite
//	public String findAllOrder(Model model) {
//		List<Order> orderList= this.orderManager.findAll();
//		for(Order order:orderList) {
//			System.out.println(order);
//		}
//		model.addAttribute("orderList", orderList);
//		return "order/findorder";
//	}

	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Order> findAllUser(){
		return this.manager.findAll();
	}

	 @RequestMapping("/upd")
	    public String update(Order order) {
		    this.orderManager.upd(order);
	        return "forward:findorder.do";
	    }
	    @RequestMapping("/delete")
	    public String delete(String orderID) {
	    	this.orderManager.deleteorder(orderID);
	        return "forward:findorder";
	    }
	    @RequestMapping("/toupdateorder")
	    public String toupdate(String orderID,Model model) {
	    	Order order=this.orderManager.findone(orderID);
	        model.addAttribute("order", order);
	        return "order/upd";
	    }
	    
	    @RequestMapping("/toadd")
	    public String toadd(){
	        return "order/addorder";
	    }
	    @RequestMapping("/addorder")
	    public String Addorder(Order order){
	        Order ord=orderManager.save(order);

	        ModelAndView s=new ModelAndView();
	        s.addObject(ord);
	        return "forward:findorder.do";
	    }


}
