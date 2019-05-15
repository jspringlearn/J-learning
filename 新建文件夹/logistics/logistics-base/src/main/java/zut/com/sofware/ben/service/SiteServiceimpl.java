package zut.com.sofware.ben.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zut.com.sofware.ben.Site;
import zut.com.sofware.ben.dao.SiteDao;
@Service("myService")
public class SiteServiceimpl implements SiteService {

	@Autowired
	private SiteDao siteDao;
	@Override
	public void add() {
		System.out.println("SiteUserService无参数");

	}

	@Override
	public void add(Site site) {
		System.out.println("SiteUserService含参数");
		//dao
		siteDao.add(site);

	}

}
