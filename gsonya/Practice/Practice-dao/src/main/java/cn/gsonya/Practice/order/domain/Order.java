package cn.gsonya.Practice.order.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import cn.gsonya.Practice.base.domain.BaseEntity;

@Entity
@Table(name="T_ORDER")
public class Order extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4853041483089883105L;
	@Column(name="CODE")
	String code;
	@Column(name="ORDER_TIME")
	Date orderTime;
	@Column(name="PRICE")
	float price;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	

}
