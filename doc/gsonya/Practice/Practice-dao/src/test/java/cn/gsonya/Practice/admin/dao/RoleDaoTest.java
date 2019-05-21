package cn.gsonya.Practice.admin.dao;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gsonya.Practice.admin.domain.Role;
import cn.gsonya.Practice.base.dao.GenericDaoTest;

public class RoleDaoTest extends GenericDaoTest<Long, Role, RoleDao> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(RoleDaoTest.class.getName());

	@Autowired
	RoleDao roleDao;

	@Test
	public void test() {
		Role r=new Role();
		r.setName("test_role");
		Role test_role=this.roleDao.save(r);
		Long role_id=test_role.getId();
		Role result=this.roleDao.getOne(role_id);
		assertEquals(test_role,result);
		List<Role>all=this.roleDao.findAll();

		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Role> all size={}", all.size()); //$NON-NLS-1$
		}
	}

}
