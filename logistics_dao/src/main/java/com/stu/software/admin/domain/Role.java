package com.stu.software.admin.domain;


import com.stu.software.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "T_ADMIN_ROLE")
public class Role extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NAME")
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
	

}
