package cn.song.sarah.service;

import java.util.List;

public interface UserManager {
	
	String sayHello(String name);

	List<User> getAll();
}
