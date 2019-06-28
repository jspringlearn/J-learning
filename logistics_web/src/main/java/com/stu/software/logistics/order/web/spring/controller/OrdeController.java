package com.stu.software.logistics.order.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Order> findAllUser(){
		return this.manager.findAll();
	}

	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public @ResponseBody
    Order deleteone(@PathVariable(value="id") Long id) {
        Order order=orderManager.findById(id);
        this.orderManager.delete(id);
        return order;
    }


    @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Order  save(Order order) {
        this.orderManager.save(order);
      return order;
    }


}
