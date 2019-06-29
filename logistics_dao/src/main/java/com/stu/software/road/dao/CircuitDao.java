package com.stu.software.road.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stu.software.dao.GenericDao;
import com.stu.software.road.domain.Circuit;


@Repository("circuitDao")
public interface CircuitDao extends GenericDao<Circuit, Long> {
    @Transactional
    @Modifying
    @Query(nativeQuery=false,value= "update Circuit c set c.entityName=?2 where c.id=?1")
    int updateName(Long id,String name);
}
