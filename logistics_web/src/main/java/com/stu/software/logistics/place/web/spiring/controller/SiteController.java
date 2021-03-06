package com.stu.software.logistics.place.web.spiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	//find addsite


//	@RequestMapping("/allsite")    //  /allsite
//	public String findAllSite(Model model) {
//		List<Site> siteList= this.siteManager.findAll();
//		for(Site site:siteList) {
//			System.out.println(site);
//		}
//		model.addAttribute("siteList", siteList);
//		return "site/findallsite";
//	}

	@ResponseBody//标识转换成JSON处理
	@GetMapping(value = "all",produces = "application/json;charset=utf-8")
	public List<Site> findAllUser(){
		return this.manager.findAll();
	}
	//
	@RequestMapping("/josn")    
	public @ResponseBody List<Site> josn(Model model) {
		List<Site> siteList= this.siteManager.findAll();
		return siteList;
	}
	
	
	//delete site 
	
	@RequestMapping("/delete")
	public String delete(int siteId) {
		this.siteManager.deleteSite(siteId);
		return "forward:allsite";//turn to /allsite
	}
	
	
	
	//update site
	@RequestMapping("/toupdatesite")
	public String toupdate(int siteId,Model model) {
		Site site=this.siteManager.findone(siteId);
		System.out.println(site);
		model.addAttribute("site", site);
		return "site/upd";
	}
	@RequestMapping("/upd")
	public  String update(Site site) {
		this.siteManager.upd(site);
		return "forward:allsite";//turn to /allsite
	}


	//save site
	@RequestMapping("/tosave")
	public String tosaveSite() {
		return "site/save";
	}
	@RequestMapping("/save")
	public String saveSite(Site site){
		this.siteManager.save(site);
		return "forward:allsite";
		
	}
}
