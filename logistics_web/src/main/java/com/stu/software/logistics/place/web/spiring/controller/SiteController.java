package com.stu.software.logistics.place.web.spiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stu.software.place.domain.Site;
import com.stu.software.place.service.SiteManager;
import com.stu.software.web.spring.controller.GenericController;


@Controller
@RequestMapping("/site")
public class SiteController extends GenericController<Site, Long, SiteManager>{
	
	SiteManager siteManager;
	@Autowired
	public void setSiteManager(SiteManager siteManager) {
		this.siteManager = siteManager;
		this.manager=this.siteManager;
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
	 * 
	 */
	@RequestMapping("/allsite")
	public String findAllSite(Model model) {
		List<Site> siteList= this.siteManager.findallsite();
		for(Site site:siteList) {
			System.out.println(site);
		}
		model.addAttribute("siteList", siteList);
		return "site/findallsite";
	}

}
