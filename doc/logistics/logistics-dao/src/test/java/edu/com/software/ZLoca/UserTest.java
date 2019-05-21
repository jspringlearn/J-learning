package edu.com.software.ZLoca;

import java.util.List;

import org.junit.Test;

import edu.com.software.ZLoca.dao.IUserDao;
import edu.com.software.ZLoca.dao.Impl.UserDaoImpl;
import edu.com.software.ZLoca.domain.User;

public class UserTest {
	@Test
    public void save() {
	User user=new User();
	user.setName("杨亚斌");
	user.setAddress("河南省郑州市新郑市龙湖镇淮河路中原工学院");
	user.setPhone("18203660460");
	IUserDao dao=new UserDaoImpl();
    dao.save(user);
    }
	@Test
	public void delete() {
		IUserDao user=new UserDaoImpl();
		user.delete("张三");
	}
	@Test
	public void update() {
		  User user=new User();
			user.setName("肖森");
			user.setAddress("河南省郑州市新郑市龙湖镇淮河路中原工学院");
			user.setPhone("13298199832");
			IUserDao dao=new UserDaoImpl();
		     dao.update(4, user);
	}
	@Test
	public void get(){
		IUserDao dao=new UserDaoImpl();
		User user=dao.get("杨亚斌");
		System.out.println(user.getName()+' '+user.getAddress()+' '+user.getPhone());
	}
	@Test
	public void getAll() {
		IUserDao dao=new UserDaoImpl();
	      List<User> stuall=dao.getAll();
	      System.out.println(stuall.toString());
	}
}
