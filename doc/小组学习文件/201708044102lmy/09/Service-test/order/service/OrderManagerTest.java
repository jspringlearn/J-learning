package com.stu.software.order.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.order.domain.Order;
import com.stu.software.service.GenericManagerTestCase;

public class OrderManagerTest extends GenericManagerTestCase<Long, Order, OrderManager> {

	 private static final Logger logger = LogManager.getLogger(OrderManagerTest.class.getName());

	    OrderManager orderManager;

	    public OrderManagerTest() {
	        super(Order.class);
	    }

	    @Autowired
	    public void setOrderManager(OrderManager orderManager) {
	        this.orderManager = orderManager;
	        this.manager  = this.orderManager;
	    }

	    @Test
	    public void testSave() {
	        logger.debug("This is a test method for AOP");
	        List<Order> orderList = new ArrayList<Order>();
	        for (int i = 0;i<10;i++) {
	            Order order = new Order();
	            orderList.add(order);

	        }
	        this.orderManager.save(orderList);
	    }

	}
