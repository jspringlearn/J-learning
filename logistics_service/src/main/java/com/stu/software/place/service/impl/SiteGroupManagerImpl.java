package com.stu.software.place.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stu.software.dao.GenericTreeDao;
import com.stu.software.place.dao.SiteGroupDao;
import com.stu.software.place.domain.SiteGroup;
import com.stu.software.place.service.SiteGroupManager;

import com.stu.software.service.impl.GenericTreeManagerImpl;

@Component
@Transactional
public class SiteGroupManagerImpl extends GenericTreeManagerImpl<SiteGroup, Long> implements SiteGroupManager {

	SiteGroupDao siteGroupDao;
	@Override
	public List<SiteGroup> findBySiteGroupName(String SiteGroupName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Autowired
	public void setSiteGroupDao(SiteGroupDao siteGroupDao) {
		this.siteGroupDao = siteGroupDao;
		this.treeDao=this.siteGroupDao;
		this.dao=this.treeDao;
		
	}
	



}
