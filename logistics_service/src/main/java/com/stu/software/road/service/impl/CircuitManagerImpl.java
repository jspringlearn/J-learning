package com.stu.software.road.service.impl;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import com.stu.software.road.dao.CircuitDao;
import com.stu.software.road.domain.Circuit;
import com.stu.software.road.service.CircuitManager;
import com.stu.software.service.impl.GenericManagerImpl;
@Service
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

}