package com.stu.software.ManagementUser.domain;

import com.stu.software.admin.domain.User;
import com.stu.software.domain.BaseTreeEntity;

public class ManagementUser extends BaseTreeEntity<ManagementUser>{
	private static final long serialVersionUID = 2956980785739215106L;


	private User user;


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
}
