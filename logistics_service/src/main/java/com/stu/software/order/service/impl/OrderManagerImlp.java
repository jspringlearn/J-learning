package com.stu.software.order.service.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.stu.software.order.dao.OrderDao;
import com.stu.software.order.domain.Order;
import com.stu.software.order.domain.Order_CURD;
import com.stu.software.order.service.OrderManager;
import com.stu.software.service.impl.GenericManagerImpl;


@Component
@Transactional
public class OrderManagerImlp extends GenericManagerImpl<Order, Long> implements OrderManager {

	
	
	OrderDao orderDao;
	
	@Autowired
	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao =orderDao;
		this.dao=this.orderDao;
	}
	
	/**
	 * findbyOrderID
	 * 
	 * find all site 
	 * **/
	@Override
	public List<Order> findbyOrderID(String orderID) {
		// TODO Auto-generated method stub
		List<Order> all=Order_CURD.getintstan().findAll();
		return all;
		
		
	}
	
	/**
	 * save
	 * 
	 * **/
	@Override
	public void saveorder(String orderID,String orderName, String orderPrice,String orderTime) {
		// TODO Auto-generated method stub
		Order order=new Order();
		order.setOrderID(orderID);
		order.setOrderName(orderName);
		order.setOrderPrice(orderPrice);
		order.setOrderTime(orderTime);
		this.orderDao.save(order);
	}
	
	/**
	 * delete
	 * 
	 * **/
	
	@Override
	public void deleteorder(String orderID) {
		// TODO Auto-generated method stub
		Order_CURD.getintstan().del(orderID);
		
	}
	
	/**
	 * update
	 * 
	 * **/
	@Override
	public void upd(Order order) {
		// TODO Auto-generated method stub
		Order_CURD.getintstan().upd(order);
		
	}
	
	/**
	 * findone
	 * 
	 * **/
	@Override
	public Order findone(String orderID) {
		// TODO Auto-generated method stub
		Order o=Order_CURD.getintstan().findOne(orderID);
		return o;
	}
	
	
}
	
	