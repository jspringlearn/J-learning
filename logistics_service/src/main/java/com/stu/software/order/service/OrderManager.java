package com.stu.software.order.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.stu.software.order.domain.Order;
import com.stu.software.service.GenericManager;

@Component
@Transactional
public interface OrderManager extends GenericManager<Order, Long> {

	
    List<Order> findbyOrderID(String orderID);
    void saveorder(String orderID,String orderName,String orderPrice);
    void deleteorder(String orderID);
    void upd(Order order);
    Order findone(String orderID);
}
