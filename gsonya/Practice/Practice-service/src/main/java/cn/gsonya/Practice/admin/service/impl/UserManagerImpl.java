package cn.gsonya.Practice.admin.service.impl;

import org.apache.logging.log4j.Logger;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gsonya.Practice.admin.dao.UserDao;
import cn.gsonya.Practice.admin.domain.User;
import cn.gsonya.Practice.admin.service.UserManager;
import cn.gsonya.Practice.base.service.Impl.GenericManagerImpl;

@Service("userManager")
public class UserManagerImpl extends GenericManagerImpl<User, Long> implements UserManager{
	/**
	 * Logger for this class
	 */
	private static final Logger logger = LogManager.getLogger(UserManagerImpl.class.getName());

	UserDao userDao;
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao=userDao;
		this.dao=this.userDao;
	}
	@Override
	public String sayHello(String name) {
		String result="Hello,"+name+"!";

		if (logger.isInfoEnabled()) {
			logger.info("sayHello(String) - String result={}", result); //$NON-NLS-1$
		}
		return result;
	}
	@Override
	public List<User>getAll(){
		List<User>all=this.userDao.findAll();

		if (logger.isInfoEnabled()) {
			logger.info("getAll() - List<User> all={}", all); //$NON-NLS-1$
		}
		return all;
	}

}
