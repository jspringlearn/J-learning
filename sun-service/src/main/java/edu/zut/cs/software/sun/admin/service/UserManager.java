package edu.zut.cs.software.sun.admin.service;

import java.util.List;

import edu.zut.cs.software.sun.admin.entitly.User;

public interface UserManager {

		public String sayHello(String name);
		public List<User> getAll();
}
