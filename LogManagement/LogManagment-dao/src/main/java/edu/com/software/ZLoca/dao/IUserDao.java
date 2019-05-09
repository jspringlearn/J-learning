package edu.com.software.ZLoca.dao;

import java.util.List;

import edu.com.software.ZLoca.domain.User;	
	
public  interface IUserDao {

		 void save(User user) ;
		 void delete(String name);
		 void update(int id,User user);
		 
		 User get(String Name);
		 List<User> getAll();

}
