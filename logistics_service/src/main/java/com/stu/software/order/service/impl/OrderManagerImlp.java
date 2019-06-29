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
	
	
	 @Override
	    public List<Order> findAll() {
	        return orderDao.findAll();
	    }

	    @Override
	    public Order save(Order order) {
	        return orderDao.save(order);
	    }


	    @Override
	    public void delete(Long id) {
	        this.orderDao.deleteById(id);
	    }

	    @Override
	    public Order findById(Long id) {
	        return orderDao.getOne(id);
	    }
	
	
	
}
	
	