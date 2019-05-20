package com.stu.software.road.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Circuit findById(Long id) {
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
	public List<Circuit> findAllBySite(int site) {
		// TODO Auto-generated method stub
		Circuit q=new Circuit();
		q.setDateCreated(null);
		q.setDateModified(null);
		q.setASiteID(site);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("site", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex=Example.of(q,matcher);
		List<Circuit> result =dao.findAll(ex);
		return result;
	}

	@Override
	public double findDistance(Long id) {
		// TODO Auto-generated method stub
		Circuit q=new Circuit();
		q.setDateCreated(null);
		q.setDateModified(null);
		q.setId(id);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("id", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex=Example.of(q,matcher);
		Circuit temp=(Circuit) dao.findAll(ex);
		double result=temp.getDistance();
		return result;
	}

	@Override
	public Circuit getsection(int aSite, int bSite) {
		// TODO Auto-generated method stub
		Circuit q1=new Circuit();
		q1.setDateCreated(null);
		q1.setDateModified(null);
		q1.setASiteID(aSite);
		q1.setBSiteID(bSite);
		
		Circuit q2=new Circuit();
		q2.setDateCreated(null);
		q2.setDateModified(null);
		q2.setASiteID(bSite);
		q2.setBSiteID(aSite);
		
		
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

	@Override
	public double getMoneyForRoad(Long id,int mod) {
		// TODO Auto-generated method stub
		double temp=findDistance(id);
		double result=temp*mod;
		return result;
	}

	@Override
	public Date getBeginTime(Long id) {
		// TODO Auto-generated method stub
		Circuit q=new Circuit();
		q.setDateCreated(null);
		q.setDateModified(null);
		q.setId(id);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("id", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex=Example.of(q,matcher);
		Circuit temp=(Circuit) dao.findAll(ex);
		Date result=temp.getBeginTime();
		return result;
	}

	@Override
	public Date getEndTime(Long id) {
		// TODO Auto-generated method stub
		Circuit q=new Circuit();
		q.setDateCreated(null);
		q.setDateModified(null);
		q.setId(id);
		ExampleMatcher matcher=ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("id", GenericPropertyMatchers.startsWith());
		Example<Circuit> ex=Example.of(q,matcher);
		Circuit temp=(Circuit) dao.findAll(ex);
		Date result=temp.getEndTime();
		return result;
	}

	   @Autowired
	    public void setCircuitDao(CircuitDao circuitDao) {
	         this.circuitDao= circuitDao;
	        this.dao = this.circuitDao;
	    }

}
