package edu.com.software.ZLoca.dao;

import java.util.List;

import edu.com.software.ZLoca.domain.User;	
	
public  interface IUserDao {

		 void save(User stu) ;
		 void delete(String id);
		 void update(String id,User stu);
		 
		 User get(String Id);
		 List<User> getAll();

}
