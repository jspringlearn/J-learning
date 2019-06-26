package com.stu.software.logistics.road.web.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stu.software.road.domain.Circuit;
import com.stu.software.road.service.CircuitManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.web.bind.annotation.ResponseBody;

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
//	@RequestMapping("/allcircuit")
//	public String findAllCircuit(Model model) {
//		List<Circuit> cList =this.circuitManager.findAll();
//		model.addAttribute("circuitList", cList);
//		return "road/allcircuit";
//	}


	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Circuit> findAllUser(){
		return this.manager.findAll();
	}
//	@RequestMapping("/delete/{id}")
//	public String dele(String id) {
//		System.out.println(id);
//		
//		this.circuitManager.delete(Long.valueOf(id));
//		return "forward:allcircuit";
//	}
	@DeleteMapping(value="delete/{id}",produces="application/json;charset=utf-8")
	public @ResponseBody void deletebyID(@PathVariable(value="id")Long id) {
		System.out.println(id);
		this.circuitManager.delete(id);
	}
//	private List<Circuit> list;
//	@GetMapping(value="findDate/{id}",produces="application/json;charset=utf-8")
//	public @ResponseBody List<Circuit>  toupda(@PathVariable(value="id")Long id) {
//		System.out.println(id);
//		Circuit circuit=this.circuitManager.findOne(id);
//		list.add(circuit);
//		return list;
//	}
	@RequestMapping(value="update",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	public @ResponseBody void upda(Circuit circuit) {
		this.circuitManager.upda(circuit);
	}
	@RequestMapping("/tosave")
	public String toSave() {
		return "road/save";
	}
//	@RequestMapping("/save")
//	public String saveCircuit(Circuit circuit) {
//		System.out.println(circuit.toString());
//		this.circuitManager.save(circuit);
//		return "forward:allcircuit";
//	}
	@RequestMapping(value="save",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	public @ResponseBody void save(Circuit circuit) {
		System.out.println(circuit.toString());
		this.circuitManager.save(circuit);
	}
}
