package edu.zut.cs.software.sun.admin.service.impl;
import java.util.List;

import org.springframework.stereotype.Service;

import edu.zut.cs.software.sun.admin.entitly.User;
import edu.zut.cs.software.sun.admin.service.UserManager;

@Service("userManager")
public class UserManagerImpl implements UserManager {

	@Override
	public String sayHello(String name) {
		String result = "Hello, " + name + "!";
		return result;
	}
	public List<User> getAll()
	{
		return null;
	}
}
