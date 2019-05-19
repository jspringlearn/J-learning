package zut.com.sofware.ben.dao;

import org.springframework.stereotype.Repository;

import zut.com.sofware.ben.Site;

@Repository
public class SiteDaoimpl implements SiteDao {

	@Override
	public void add(Site site) {
		System.out.println("增加"+site );

	}

	@Override
	public void delete(Site site) {
		System.out.println("删除"+site );

	}

}
