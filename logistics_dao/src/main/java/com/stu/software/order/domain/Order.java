package com.stu.software.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.stu.software.domain.BaseTreeEntity;


@Table(name = "T_ORDER")
@Entity
@NamedQueries({ @NamedQuery(name = "Order.getRoot", query="select g from Order g  where g.parent is null") })
public class Order extends BaseTreeEntity<Order> {


	
	private static final long serialVersionUID = 4475744750767977852L;
	
	@Column(name="ORDER_ID")
	String OrderID;

	
	@Column(name="ORDER_TIME")
	String OrderTime;
	@Column(name="PRICE")
	String OrderPrice;
	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		this.OrderTime = orderTime;
	}

	public String getOrderPrice() {
		return OrderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.OrderPrice = orderPrice;
	}

	public String getOrderID() {
		return OrderID;
	}

	public void setOrderID(String orderID) {
		this.OrderID = orderID;
	}

	
	

	
}