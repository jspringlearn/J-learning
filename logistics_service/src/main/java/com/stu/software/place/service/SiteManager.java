package com.stu.software.place.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.stu.software.place.domain.Site;
import com.stu.software.service.GenericManager;

@Component
@Transactional
public interface SiteManager extends GenericManager<Site, Long> {
	/**
	 * 查询地点编号
	 * @param SiteId
	 * @return
	 */
	List<Site> findBySite(String SiteId);
	/**
	 * 地点名称
	 * @param SiteName
	 * @return
	 */
	List<Site> findBySiteName(String SiteName);
    /**
     * 地点简介（信息）
     * @param SiteInfo
     * @return
     */
	List<Site> findBySiteInfo(String SiteInfo);
	void savesite();
	
	List<Site> findallsite();


}
