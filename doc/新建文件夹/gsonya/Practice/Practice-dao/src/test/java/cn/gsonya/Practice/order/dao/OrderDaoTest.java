package cn.gsonya.Practice.order.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.gsonya.Practice.base.dao.GenericDaoTest;
import cn.gsonya.Practice.order.domain.Order;

public class OrderDaoTest extends GenericDaoTest<Long, Order, OrderDao> {
	OrderDao orderDao;
	@Autowired
	public void setOrderDao(OrderDao orderDao)
	{
		this.orderDao=orderDao;
		this.dao=this.orderDao;
	}

	@Test
	public void testFindAll() {
		for(int i=0;i<10;i++) {
			Order order=new Order();
			order.setCode("Order_Code_"+i);
			Order newOrder=this.orderDao.save(order);
			assertNotNull(newOrder);
		}
		List<Order>result=this.orderDao.findAll();
	}

}
