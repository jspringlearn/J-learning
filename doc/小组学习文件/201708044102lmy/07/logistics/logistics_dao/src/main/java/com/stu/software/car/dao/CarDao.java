package com.stu.software.car.dao;

import com.stu.software.car.domain.Car;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

@Repository("carDao")
public interface CarDao extends GenericDao<Car, Long> {

}
