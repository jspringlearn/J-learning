package cn.gsonya.Practice.base.domain;
//上课讲的

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="T_DEVICE")
public class device extends BaseEntity {
	@Column(name="LOCATION")
	String location;
	@Column(name="PRICE")
	float price;
	@Column(name="VANDOR")
	String vandor;
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getVandor() {
		return vandor;
	}
	public void setVandor(String vandor) {
		this.vandor = vandor;
	}
	

}
