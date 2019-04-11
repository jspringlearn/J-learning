package cn.gsonya.Hibernate.model;

import java.util.HashSet;
import java.util.Set;

public class Person {
	private int id;
    private String name;
    private Set<String> address = new HashSet<String>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<String> getAddress() {
		return address;
	}
	public void setAddress(Set<String> address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
      

}
