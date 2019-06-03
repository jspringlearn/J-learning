package com.stu.software.order.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.stu.software.order.domain.Order;
import com.stu.software.service.GenericManager;

@Component
@Transactional
public interface OrderManager extends GenericManager<Order, Long> {

	

    Order findbyOrderID(String orderId);
}
