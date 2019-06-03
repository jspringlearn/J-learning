package com.stu.software.order.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.stu.software.domain.BaseEntity;


@Entity
@Table(name = "T_ORDER")
public class Order extends BaseEntity {


	private static final long serialVersionUID = 4475744750767977852L;
	
    @Column(name="ORDER_ID")
	String OrderID;
    @Column(name="ORDER_NAME")
	String OrderName;
    @Column(name="ORDER_TIME")
	String OrderTime;
	@Column(name="PRICE")
	String OrderPrice;
	
	 @ManyToOne
	 @JoinColumn(name="	TYPES_ID")
	 Types types;
	
	 
	 
	 public String getOrderID() {
			return OrderID;
		}
	 public void setOrderID(String orderID) {
			this.OrderID = orderID;
		}
	public String getOrderTime() {
		return OrderTime;
	}

	public void setOrderTime(String orderTime) {
		this.OrderTime = orderTime;
	}
	public String getOrderName() {
		return OrderName;
	}

	public void setOrderName(String orderName) {
		OrderName = orderName;
	}
	public String getOrderPrice() {
		return OrderPrice;
	}

	public void setOrderPrice(String orderPrice) {
		this.OrderPrice = orderPrice;
	}

	

	public Types getTypes() {
		return types;
	}

	public void setTypes(Types types) {
		this.types = types;
	}
	

	
}