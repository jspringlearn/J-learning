package com.stu.software.road.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stu.software.road.RMapManager;
import com.stu.software.road.dao.RMapDao;
import com.stu.software.road.domain.RMap;
import com.stu.software.service.impl.GenericTreeManagerImpl;



@Service("rmapmanager")
@Transactional
public class RMapManagerImp extends GenericTreeManagerImpl<RMap, Long> implements RMapManager {

	RMapDao rMapDao;
	public List<RMap> getAncestors(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RMap> getChildren(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RMap> getDescendants(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RMap> getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public RMap findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RMap> save(Iterable<RMap> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public RMap save(RMap entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<RMap> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getAllDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date getAllTime() {
		// TODO Auto-generated method stub
		return null;
	}

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
