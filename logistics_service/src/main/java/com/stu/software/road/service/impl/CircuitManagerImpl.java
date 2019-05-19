package com.stu.software.road.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.road.CircuitManager;
import com.stu.software.road.dao.CircuitDao;
import com.stu.software.road.domain.Circuit;
import com.stu.software.service.impl.GenericManagerImpl;


@Component
@Transactional
public class CircuitManagerImpl extends GenericManagerImpl<Circuit, Long> implements CircuitManager {

	CircuitDao circuitDao;
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	public Circuit findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Circuit> save(Iterable<Circuit> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	public Circuit save(Circuit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Circuit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public int findDistance(String ASite, String BSite) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Circuit section(String ASite, String BSite) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getMoneyForRoad() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Date getBeginTime(String ASite, String BSite) {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getEndTime(String ASite, String BSite) {
		// TODO Auto-generated method stub
		return null;
	}

    @Autowired
    public void setUserDao(CircuitDao circuitDao) {
        this.circuitDao = circuitDao;
        this.dao = this.circuitDao;
    }
}
