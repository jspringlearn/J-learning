package edu.zut.cs.software.admin.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.admin.entity.User;
import edu.zut.cs.software.admin.service.UserManager;

@Service("usermanager")
public class UserManagerImpl implements UserManager {

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		String result="Hello "+name+"!";
		return result;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
