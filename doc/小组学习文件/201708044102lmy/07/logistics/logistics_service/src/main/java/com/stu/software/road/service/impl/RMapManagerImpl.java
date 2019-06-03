package com.stu.software.road.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stu.software.road.dao.RMapDao;
import com.stu.software.road.domain.RMap;
import com.stu.software.road.service.RMapManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;

public class RMapManagerImpl extends GenericTreeManagerImpl<RMap, Long> implements RMapManager {

	RMapDao rMapDao;
	@Override
	public List<RMap> getAncestors(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RMap> getChildren(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RMap> getDescendants(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RMap> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RMap> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<RMap> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RMap findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RMap> save(Iterable<RMap> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RMap save(RMap entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RMap> findAllCircuit(int beginSiteID, int endSiteID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getAllDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Date getAllTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAllMoney() {
		// TODO Auto-generated method stub
		return 0;
	}

	   @Autowired
	    public void setGroupDao(RMapDao rMapDao) {
	        this.rMapDao = rMapDao;
	        this.treeDao = this.rMapDao;
	        this.dao = this.treeDao;
	    }
}
