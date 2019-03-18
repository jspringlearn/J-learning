package edu.zut.cs.software.admin.service;

import java.util.List;

import edu.zut.cs.software.admin.entity.User;

public interface UserManager {

	String sayHello(String name);
	public List<User> getAll();

}
