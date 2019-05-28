package com.stu.software.road.service;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.road.domain.Circuit;
import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericGenerator;

public class RoadEntityGenerator extends GenericGenerator {

	@Autowired
	RMapManager rMapManager;
	@Autowired
	CircuitManager circuitManager;

	@Test
	public void gen_RMap() {
		for(int i=0;i<10;i++) {
			RMap r=new RMap();
			r.setCircuitName("circuit_"+i);
			this.rMapManager.save(r);
			for(int j=0;j<10;j++) {
				RMap rMap=new RMap();
				rMap.setCircuitName("circuit_"+i+"_"+j);
				rMap.setParent(r);
				r=this.rMapManager.save(rMap);
				this.gen_circuit(rMap);
			}
		}
	}
	
	public void gen_circuit(RMap r) {
		for(int i=0;i<10;i++) {
			Circuit c=new Circuit();
			c.setaSite(i+"");
			c.setbSite(i+10+"");
			c.setDistance(i+i*2+0.2564*i);
			c.setRMap(r);
			this.circuitManager.save(c);
		}
	}

}
