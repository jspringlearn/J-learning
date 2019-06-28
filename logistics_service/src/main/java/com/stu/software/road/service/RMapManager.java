package com.stu.software.road.service;

import java.util.List;

import com.stu.software.road.domain.Circuit;
import com.stu.software.road.domain.RMap;
import com.stu.software.service.GenericTreeManager;

/**
 * @author 谢国欣
 * @title
 * @Package com.stu.software.admin.service
 * @date 2019/5/20 15:49
 */

public interface RMapManager extends GenericTreeManager<RMap, Long> {

	   /**
     * * find all entity
     *
     * 
     */
	List<RMap> findAll();
	   /**
     * fetch specified entity according gName;
     *
     * @param gName
     *            entity gName;
     * @return entity
     */
	RMap findByGroupName(String gName);
	   /**
     * fetch specified entity according aSite and bSite;
     *
     * @param aSite,bSite
     *            entity aSite,bSite;
     * @return entity
     */
	List<Circuit> findBySite(String aSite,String bSite);
}
