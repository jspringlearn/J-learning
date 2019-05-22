package com.stu.software.place.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stu.software.place.domain.Site;
import com.stu.software.place.service.SiteManager;
import com.stu.software.service.impl.GenericManagerImpl;

public class SiteManagerImpl extends GenericManagerImpl<Site, Long> implements SiteManager {

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Site> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> save(Iterable<Site> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Site save(Site entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> findBySite(String SiteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> findBySiteName(String SiteName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Site> findBySiteInfo(String SiteInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
