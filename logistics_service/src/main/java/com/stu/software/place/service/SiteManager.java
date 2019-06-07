package com.stu.software.place.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.stu.software.place.domain.Site;
import com.stu.software.service.GenericManager;

@Component
@Transactional
public interface SiteManager extends GenericManager<Site, Long> {
	
	void savesite(String name,String info);
	List<Site> findallsite();


}
