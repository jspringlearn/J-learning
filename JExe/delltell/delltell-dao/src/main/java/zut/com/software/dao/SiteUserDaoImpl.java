package zut.com.software.dao;

import zut.com.software.domain.Site;

public class SiteUserDaoImpl implements SiteUserDao {

	@Override
	public void add(Site site) {

		System.out.println("增加"+site );

	}

	@Override
	public void delete(Site site) {
		System.out.println("删除"+site);

	}

}
