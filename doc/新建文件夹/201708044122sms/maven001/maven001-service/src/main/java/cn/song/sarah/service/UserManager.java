package cn.song.sarah.service;

import java.util.List;

public interface UserManager<User> {
	
	String sayHello(String name);

	List<User> getAll();
}
