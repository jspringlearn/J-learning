package cn.gsonya.Practice.admin.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import cn.gsonya.Practice.base.domain.BaseEntity;

@Table(name="T_ADMIN_USER")
@Entity
public class User extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7964741454191232829L;
	@Column(name="EMAIL")
	String email;
	@ManyToOne
	@JoinColumn(name="GROUP_ID")
	Group group;
	@Column(name="PASSWORD")
	String password;
	@Column(name="USENAME")
	String username;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	

}
