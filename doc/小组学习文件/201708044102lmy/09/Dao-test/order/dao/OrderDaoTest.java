package com.stu.software.order.dao;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;
import com.stu.software.order.dao.OrderDao;
import com.stu.software.order.domain.Order;



public class OrderDaoTest extends GenericDaoTestCase<Long, Order, OrderDao> {


	  private static final Logger logger = LogManager.getLogger(OrderDaoTest.class.getName());

	    @Autowired
	    OrderDao orderDao;

	    @Test
	        public void testGetRoot() {
	           int n=2;
	            for(int i = 1; i <= n; i++) {
	                Order order = new Order();
	                order.setOrderName("order_" + i);
	                order.setOrderName("order_" + i);
	                this.orderDao.save(order);
	            }

	        List<Order> all = this.orderDao.findAll();
	        if (logger.isInfoEnabled()) {
	            logger.info("test() - List<order> all size ={}", all.size()); //$NON-NLS-1$
	        }

	        }
}
