package com.stu.software.road.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Component;

import com.stu.software.road.dao.CircuitDao;
import com.stu.software.road.domain.Circuit;
import com.stu.software.road.service.CircuitManager;
import com.stu.software.service.impl.GenericManagerImpl;
@Component
@Transactional
class CircuitManagerImpl extends GenericManagerImpl<Circuit, Long> implements CircuitManager {

	CircuitDao circuitDao;


	@Override
	public Circuit findByID(Long id) {
		// TODO Auto-generated method stub
		Circuit q =new Circuit();
		q.setDateCreated(null);
		q.setDateModified(null);
		q.setId(id);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("id", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex =Example.of(q, matcher);
		Circuit result =(Circuit) dao.findAll(ex);
		return result;
	}



	@Override
	public Circuit findBySection(String aSite, String bSite) {
		// TODO Auto-generated method stub
		Circuit q1=new Circuit();
		q1.setDateCreated(null);
		q1.setDateModified(null);
		q1.setaSite(aSite);
		q1.setbSite(bSite);
		
		Circuit q2=new Circuit();
		q2.setDateCreated(null);
		q2.setDateModified(null);
		q2.setaSite(bSite);
		q2.setbSite(aSite);
		
		
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("aSite", GenericPropertyMatchers.startsWith())
				.withMatcher("bSite", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex1=Example.of(q1,matcher);
		Example<Circuit> ex2=Example.of(q2,matcher);
		List<Circuit> temp= dao.findAll(ex1);
		temp.addAll(dao.findAll(ex2));
		Circuit result=temp.get(0);
		return result;
	}

	@Autowired
	public void setCircuitDao(CircuitDao circuitDao)
	{
		this.circuitDao=circuitDao;
		this.dao=this.circuitDao;
	}



	@Override
	public String route(Circuit circuit) {
		String r=circuit.getRoute_one();
		double dis =circuit.getDistance_one();
		if(dis > circuit.getDistance_two()) {
			dis=circuit.getDistance_two();
			r=circuit.getRoute_two();
		}else if(dis>circuit.getDistance_three()) {
			dis=circuit.getDistance_three();
			r=circuit.getRoute_three();
		}
		return r;
	}

}