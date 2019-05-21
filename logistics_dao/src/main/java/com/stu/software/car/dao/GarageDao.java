package com.stu.software.car.dao;

import com.stu.software.car.domain.Garage;
import com.stu.software.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("garageDao")
public interface GarageDao extends GenericTreeDao<Garage, Long> {

}
