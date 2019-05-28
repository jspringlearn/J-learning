package com.stu.software.order.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;
import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.order.dao.OrderDao;
import com.stu.software.order.domain.Order;

public class OrderDaoTest extends GenericDaoTestCase<Long, Order, OrderDao> {

	
	OrderDao orderDao;
	    @Autowired
	    public void setOrderDao(OrderDao orderDao){
	        this.orderDao=orderDao;
	        this.dao=this.orderDao;
	    }
	    @Test
	    public void testGetRoot(){
	        int root_size=10;
	        for(int i=0;i<root_size;i++){
	            Order order=new Order();
	            order.setOrderID("order_"+i);
	            for(int j=0;j<10;j++) {
	                Order g=new Order();
	                g.setOrderID("order_"+i+"_"+j);
//	                g.setParent(order);
	     
	            }
	            this.orderDao.save(order);
	        }
//	        List<Order> roots=this.orderDao.getRoot();
//	        assertEquals(root_size,roots.size());

//	        if (logger.isInfoEnabled()) {
//	            logger.info("testGetRoot() - List<Boss> roots={}", roots); //$NON-NLS-1$
	        
	    }
}
