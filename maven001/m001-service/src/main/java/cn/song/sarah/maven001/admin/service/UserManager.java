package cn.song.sarah.maven001.admin.service;

import java.util.List;

import cn.song.sarah.maven001.admin.entity.User;
public interface UserManager {

	String sayHello(String name);

	List<User> getAll();
}
