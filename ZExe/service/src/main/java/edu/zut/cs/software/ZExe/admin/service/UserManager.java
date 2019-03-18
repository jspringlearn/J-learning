package edu.zut.cs.software.ZExe.admin.service;

import java.util.List;

import edu.zut.cs.software.ZExe.admin.entity.User;

public interface UserManager {

		String sayHello(String name);

		List<User> getAll();

		
}
