package com.stu.software.road.service;




import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.road.domain.Circuit;
import com.stu.software.service.GenericManagerTestCase;


public class CircuitManagerTest extends GenericManagerTestCase<Long, Circuit, CircuitManager> {

	private static final Logger logger = LogManager.getLogger(CircuitManagerTest.class.getName());

	

	public CircuitManagerTest() {
		super(Circuit.class);
	}
	CircuitManager circuitManager;
	
	
	@Autowired
	public void setCircuitManager(CircuitManager circuitManager) {
		this.circuitManager=circuitManager;
		this.manager=this.circuitManager;
	}
	@Test
	public void testSave() {
		logger.debug("This is a test method for AOP");
		List<Circuit> cList =new ArrayList<Circuit>();
		for(int i=0;i<10;i++) {
			Circuit circuit=new Circuit();
			cList.add(circuit);
		}
		this.circuitManager.save(cList);
	}

}
