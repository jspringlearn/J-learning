package com.stu.software.road.service;

import java.util.List;
import com.stu.software.road.domain.Circuit;
import com.stu.software.service.GenericManager;

/**
 * @author 谢国欣
 * @title
 * @Package com.stu.software.admin.service
 * @date 2019/5/20 15:49
 */
public interface CircuitManager extends GenericManager<Circuit, Long> {

	void upda(Circuit circuit);
	   /**
     * * find all entity
     *
     * 
     */
    List<Circuit> findAll();
    /**
     * fetch specified entity according id;
     *
     * @param id
     *            entity id;
     * @return entity
     */
    Circuit findOne(Long id);
    /**
     * fetch specified entity according aSite and bSite;
     *
     * @param aSite,bSite
     *            entity aSite,bSite;
     * @return entity
     */
    
    Circuit findBySection(String aSite,String bSite);
    
    /**
     * route
     */
    int update(Long id,String name);
    //String route(Circuit circuit);
}
