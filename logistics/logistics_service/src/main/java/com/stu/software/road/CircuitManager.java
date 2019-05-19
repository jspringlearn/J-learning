package com.stu.software.road;

import java.util.Date;
import java.util.List;

import com.stu.software.road.domain.Circuit;
import com.stu.software.service.GenericManager;



public interface CircuitManager extends GenericManager<Circuit, Long> {

    List<Circuit> findAll();
    int findDistance(String ASite,String BSite);
    Circuit section(String ASite,String BSite);
    int getMoneyForRoad();
    Date getBeginTime(String ASite,String BSite);
    Date getEndTime(String ASite,String BSite);
}
