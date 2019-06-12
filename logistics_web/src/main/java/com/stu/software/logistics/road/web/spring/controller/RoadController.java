package com.stu.software.logistics.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.software.road.domain.Circuit;
import com.stu.software.road.service.CircuitManager;
import com.stu.software.web.spring.controller.GenericController;
@Controller
@RequestMapping("/road")
public class RoadController extends GenericController<Circuit, Long, CircuitManager> {

	CircuitManager circuitManager;
	@Autowired
	public void setCircuitManager(CircuitManager circuitManager) {
		this.circuitManager=circuitManager;
		this.manager=this.circuitManager;
	}
	
	
	@RequestMapping("/index")
	public String mainIndex() {
		return "main/index";
	}
	@RequestMapping("/allcircuit")
	public String findAllCircuit(Model model) {
		List<Circuit> cList =this.circuitManager.findAll();
		model.addAttribute("circuitList", cList);
		return "road/allcircuit";
	}
	
}
