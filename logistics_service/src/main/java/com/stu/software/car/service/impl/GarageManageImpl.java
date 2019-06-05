package com.stu.software.car.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stu.software.car.dao.GarageDao;
import com.stu.software.car.domain.Garage;
import com.stu.software.car.service.GarageManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;

/**
 * @author 宋明硕
 * @title
 * @Package com.stu.software.admin.service.impl
 * @date 2019/5/27 9:27
 */
@Service("GarageManager")
public class GarageManageImpl extends GenericTreeManagerImpl<Garage, Long> implements GarageManager {
	GarageDao garageDao;
	@Autowired
	public void setGarageDao(GarageDao garageDao) {
		this.garageDao = garageDao;
		this.treeDao = this.garageDao;
		this.dao = this.treeDao;
	}

}
