package edu.zut.cs.software.bean;

import org.springframework.stereotype.Service;

@Service("UserManager")
public class UserManager implements ExeTest {

	public String say(String name) {
		// TODO Auto-generated method stub
		String str="hello"+name;
		return str;
	}
	public static void main() {}
}
