package edu.com.software.ZLoca;

import org.junit.Test;

import edu.com.software.ZLoca.dao.IUserDao;
import edu.com.software.ZLoca.dao.Impl.UserDaoImpl;
import edu.com.software.ZLoca.domain.User;

public class UserTest {
	@Test
    public void save() {
	User user=new User();
	user.setName("李四");
	user.setAddress("河南省郑州市新郑市龙湖镇淮河路中原工学院");
	user.setPhone("18209876543");;
	IUserDao dao=new UserDaoImpl();
    dao.save(user);
    }
}
