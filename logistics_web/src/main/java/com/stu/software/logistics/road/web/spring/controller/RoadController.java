package com.stu.software.logistics.road.web.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
