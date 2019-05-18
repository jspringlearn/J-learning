package com.stu.software.admin;

import static org.junit.Assert.assertEquals;

import com.stu.software.admin.dao.RoleDao;
import com.stu.software.admin.domain.Role;
import com.stu.software.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class RoleDaoTest extends GenericDaoTestCase<Long, Role, RoleDao> {
	/**
	 * Logger for this class
	 * private static final Logger logger = LogManager.getLogger(GroupDaoTest.class.getName());     //不太理解、、、
	 */

	@Autowired
	RoleDao roleDao;

	@Test
	public void test() {
		Role r = new Role();
		r.setName("test_role");
		Role test_role = this.roleDao.save(r);
		Long role_id = test_role.getId();
		Role result = this.roleDao.getOne(role_id);
		List<Role> all = this.roleDao.findAll();
		if (logger.isInfoEnabled()) {
			logger.info("test() - List<Role> all size ={}", all.size()); //$NON-NLS-1$
		}
	}
}

