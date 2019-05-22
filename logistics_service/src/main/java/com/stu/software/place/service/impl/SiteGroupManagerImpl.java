package com.stu.software.place.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.stu.software.place.domain.SiteGroup;
import com.stu.software.place.service.SiteGroupManager;
import com.stu.software.service.impl.GenericManagerImpl;

public class SiteGroupManagerImpl extends GenericManagerImpl<SiteGroup, Long> implements SiteGroupManager {

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SiteGroup> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<SiteGroup> findAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteGroup findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteGroup> save(Iterable<SiteGroup> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SiteGroup save(SiteGroup entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SiteGroup> findBySiteGroupName(String SiteGroupName) {
		// TODO Auto-generated method stub
		return null;
	}

}
