package com.stu.software.road.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;

import com.stu.software.road.dao.RMapDao;
import com.stu.software.road.domain.Circuit;
import com.stu.software.road.domain.RMap;
import com.stu.software.road.service.CircuitManager;
import com.stu.software.road.service.RMapManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;

public class RMapManagerImpl extends GenericTreeManagerImpl<RMap, Long> implements RMapManager {

	RMapDao rMapDao;




	@Override
	public RMap findByGroupName(String gName) {
		RMap r=new RMap();
		r.setDateCreated(null);
		r.setDateModified(null);
		r.setCircuitName(gName);
		ExampleMatcher matcher = ExampleMatcher.matching()
				.withStringMatcher(StringMatcher.CONTAINING)
				.withIgnoreCase(true)
				.withMatcher("gName", GenericPropertyMatchers.startsWith());
		Example<RMap> ex=Example.of(r,matcher);
		RMap result =(RMap) dao.findAll(ex);
		return result;
	}


	@Override
	public List<Circuit> findBySite(String aSite, String bSite) {
		// TODO Auto-generated method stub
		RMap r=new RMap();
		r.setDateCreated(null);
		r.setDateModified(null);
		
		return null;
	}
	   
	@Autowired
	public void setGroupDao(RMapDao rMapDao) {
		this.rMapDao = rMapDao;
	    this.treeDao = this.rMapDao;
	    this.dao = this.treeDao;
	    }

}
