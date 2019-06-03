package com.stu.software.order.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.order.domain.Order;
import com.stu.software.order.domain.Types;
import com.stu.software.service.GenericGenerator;

public class OrderEntityGenerator extends GenericGenerator {
	
	@Autowired
	OrderManager orderManager;
	@Autowired
	TypesManager typesManager;
	
	@Test
	
	 public void gen_types() {
        for (int i = 0; i < 4; i++) {
            Types s =new Types();
            s.setName("types_" + i);
            this.typesManager.save(s);
            for (int j = 0; j < 4; j++) {
                Types types = new Types();
                types.setName("types_" + i + "_" + j);
                types.setParent(s);
                s = this.typesManager.save(types);
                this.gen_order(s);
            }
        }
    }
	

	 public void gen_order(Types s) {
        for (int i = 0; i <10; i++) {
            Order order = new Order();
            order.setOrderID("order_i");
            order.setTypes(s);
            this.orderManager.save(order);
        }
    }
	

}
