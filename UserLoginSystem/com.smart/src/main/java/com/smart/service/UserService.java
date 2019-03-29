package com.smart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
//import com.smart.dao.jdbc.*;

@Service 
public class UserService {
	
	private UserDao userDao;
	private LoginLogDao loginLogDao;
	@Autowired
	public void setLoginLogDao(LoginLogDao loginLogDao) {
		this.loginLogDao=loginLogDao;
	}
	public boolean hasMatchUser(String userName,String password) {
		int matchCount=userDao.getMatchCount(userName, password);
		return matchCount>0;
	}
	public User findUserByUserName(String userName) {
		return userDao.findUserByUserName(userName);
	}
	@Transactional
	public void loginSucess(User user) {
		user.setCredits(5+user.getCredits());
		LoginLog loginLog=new LoginLog();
		loginLog.setUserId(user.getLastIp());
		loginLog.setIp(user.getLastIp());
		loginLog.setLoginDate(user.getLastVisit());
		userDao.updateLoginInfo(user);
		LoginLogDao.insertLoginLog(loginLog);
	}

}
