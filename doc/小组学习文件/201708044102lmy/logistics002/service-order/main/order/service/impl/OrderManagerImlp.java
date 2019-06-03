package com.stu.software.order.service.impl;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.order.dao.OrderDao;
import com.stu.software.order.domain.Order;
import com.stu.software.order.service.OrderManager;
import com.stu.software.service.impl.GenericManagerImpl;


@Component
@Transactional
public class OrderManagerImlp extends GenericManagerImpl<Order, Long> implements OrderManager {

	
	
	OrderDao orderDao;
	
	    
	    
	@Override
	public Order findbyOrderID(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao =orderDao;
		this.dao=this.orderDao;
	}
}

