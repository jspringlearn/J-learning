package com.stu.software.road.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.dao.GenericDao;
import com.stu.software.road.domain.Circuit;


@Repository("circuitDao")
public interface CircuitDao extends GenericDao<Circuit, Long> {

}
