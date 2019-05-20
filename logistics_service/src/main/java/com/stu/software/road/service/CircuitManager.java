package com.stu.software.road.service;

import java.util.Date;
import java.util.List;

import com.stu.software.road.domain.Circuit;
import com.stu.software.service.GenericManager;



public interface CircuitManager extends GenericManager<Circuit, Long> {

    List<Circuit> findAllBySite(int site);
    double findDistance(Long id);
    Circuit getsection(int aSite,int bSite);
    double getMoneyForRoad(Long id,int mod);
    Date getBeginTime(Long id);
    Date getEndTime(Long id);
}
