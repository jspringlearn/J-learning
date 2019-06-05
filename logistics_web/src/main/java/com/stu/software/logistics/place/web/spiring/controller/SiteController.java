package com.stu.software.logistics.place.web.spiring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/site")
public class SiteController {
	
	@RequestMapping("/index")
	public String siteIndex(){
		return "main/index";
	}

}
