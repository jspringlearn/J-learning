package edu.zut.cs.software.ZExe.admin.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.ZExe.admin.entity.User;
import edu.zut.cs.software.ZExe.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name + "!";
		return result;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
