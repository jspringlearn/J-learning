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
	@RequestMapping("/upd")
	public String update(Site site) {
		System.out.println(site);
		this.siteManager.upd(site);
		//this.siteManager.upd(site);
		return "forward:allsite.do";//turn to /allsite
	}


	@RequestMapping("/allsite")    //  /allsite
	public String findAllSite(Model model) {
		List<Site> siteList= this.siteManager.findAll();
		for(Site site:siteList) {
			System.out.println(site);
		}
		model.addAttribute("siteList", siteList);
		return "site/findallsite";
	}
	@RequestMapping("/delete")
	public String delete(int siteId) {
		this.siteManager.deleteSite(siteId);
		return "forward:allsite";//turn to /allsite
	}
	@RequestMapping("/toupdatesite")
	public String toupdate(int siteId,Model model) {
		Site site=this.siteManager.findone(siteId);
		System.out.println(site);
//		Model model=new Model();
		model.addAttribute("site", site);
		return "site/upd";
	}


}
