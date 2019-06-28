package com.stu.software.order.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import com.stu.software.order.domain.Order;
import com.stu.software.service.GenericManager;

@Component
@Transactional
public interface OrderManager extends GenericManager<Order, Long> {

	List<Order> findAll();//find all information about order
    Order save(Order order);//save the information to add
    void delete(Long id);//delete the information according to id
    Order findById(Long id);//search by id
}
