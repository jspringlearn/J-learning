package com.stu.software.order.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.dao.GenericDao;
import com.stu.software.order.domain.Order;

@Repository("orderDao")
public interface OrderDao extends GenericDao<Order, Long> {

}
