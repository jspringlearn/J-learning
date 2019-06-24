package com.stu.software.car.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.stu.software.car.dao.GarageDao;
import com.stu.software.car.domain.Garage;
import com.stu.software.car.service.GarageManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;
@Component
@Transactional
/**
 * @author 宋明硕
 * @title
 * @Package com.stu.software.admin.service.impl
 * @date 2019/5/27 9:27
 */

public class GarageManageImpl extends GenericTreeManagerImpl<Garage, Long> implements GarageManager {
	GarageDao garageDao;
	@Autowired
	public void setGarageDao(GarageDao garageDao) {
		this.garageDao = garageDao;
		this.treeDao = this.garageDao;
		this.dao = this.treeDao;
	}

}
