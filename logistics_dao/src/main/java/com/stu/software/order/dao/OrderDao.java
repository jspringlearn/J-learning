package com.stu.software.order.dao;


import com.stu.software.dao.GenericTreeDao;
import com.stu.software.order.domain.Order;
import org.springframework.stereotype.Repository;

@Repository("orderDao")
public interface OrderDao extends GenericTreeDao<Order, Long> {

}
