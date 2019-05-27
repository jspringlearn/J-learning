package com.stu.software.order.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.order.domain.Order;
import com.stu.software.service.GenericGenerator;

public class OrderEntityGenerator extends GenericGenerator {
	
	@Autowired
	OrderManager orderManager;
	
	@Test
	 public void gen_order() {
        for (int i = 0; i <4; i++) {
            Order g = new Order();
            g.setOrderID("order_i");//.setName("goods_i");
            this.orderManager.save(g);
        }
    }
	

}
