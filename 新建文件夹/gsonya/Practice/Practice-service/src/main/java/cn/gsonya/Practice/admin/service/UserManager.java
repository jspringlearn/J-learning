package cn.gsonya.Practice.admin.service;

import java.util.List;

import cn.gsonya.Practice.admin.domain.User;
import cn.gsonya.Practice.base.service.GenericManager;

public interface UserManager extends GenericManager<User, Long> {
	String sayHello(String name);
	List<User>getAll();

}
