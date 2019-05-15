package cn.song.sarah.maven001.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "t3")
@Entity


public class User {
	private String kinds;   //汽车种类
	private String address;   //地址
	private String volume;    //容量
	
	
	
	
	
	
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
