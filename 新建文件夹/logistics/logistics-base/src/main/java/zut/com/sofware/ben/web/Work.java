package zut.com.sofware.ben.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import zut.com.sofware.ben.Site;
import zut.com.sofware.ben.service.SiteService;

@Controller
public class Work {
	
	@Autowired
	@Qualifier("myService")
	private SiteService siteService;
	public void save (Site site) {
		System.out.println("工作保存"+site);
		siteService.add(site);
	}
	public void delete(Site site) {
		System.out.println("工作删除"+site);
//		siteService.delete(site);
	}

}
