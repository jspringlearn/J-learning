package com.stu.software.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.stu.software.domain.BaseEntity;

@Entity
@Table(name = "T_ORDER")
public class Order extends BaseEntity {

	/**
	 * 
	 */

	
	private static final long serialVersionUID = 4475744750767977852L;

	@Column
	String OrderID;

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		this.OrderID = orderID;
	}

	
	

	
}