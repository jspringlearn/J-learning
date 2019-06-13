package com.stu.software.ManagementUser.domain;


import com.stu.software.domain.BaseEntity;
import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;

@Entity
@Table(name="T_Management")
public class ManagementUser extends BaseTreeEntity <ManagementUser>{
	private static final long serialVersionUID = 2956980785739215106L;
	/**
	 * Management_Name 管理员姓名
	 *
	 *
	 * Management_MPhone管理员电话
	 */
	@Column(name="Management_MName")
	 String MName;
	@Column(name="Management_MPhone")
	 String MPhone;
	@Column(name="Management_ID")
	int ManagementID;

	public int getManagementID() {
		return ManagementID;
	}

	public void setManagementID(int managementID) {
		ManagementID = managementID;
	}

	@ManyToOne
	@JoinColumn(name="ManagementUserGroup_ID")
	 ManagementUserGroup managementUserGroup;

	public ManagementUserGroup getManagementUserGroup() {
		return managementUserGroup;
	}

	public void setManagementUserDaoGroup(ManagementUserGroup managementUserGroup) {
		this.managementUserGroup = managementUserGroup;
	}

	public void setMName(String mname) {
		MName = mname;
	}

	public void setMPhone(String MPhone) {
		this.MPhone = MPhone;
	}

	public String getMName() {
		return MName;
	}

	public String getMPhone() {
		return MPhone;
	}

	@Override
	public String toString() {
		return "ManagementUser [ MName=" + MName + ", MPhone=" + MPhone  +"]";
	}
}
