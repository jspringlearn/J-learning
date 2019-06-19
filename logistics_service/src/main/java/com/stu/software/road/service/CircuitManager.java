package com.stu.software.road.service;

import java.util.List;



import com.stu.software.road.domain.Circuit;
import com.stu.software.service.GenericManager;


public interface CircuitManager extends GenericManager<Circuit, Long> {

	void upda(Circuit circuit);
    List<Circuit> findAll();
    Circuit findOne(Long id);
    Circuit findBySection(String aSite,String bSite);
    
    /**
     * route
     */
    String route(Circuit circuit);
}
