package com.stu.software.place.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.dao.GenericDao;
import com.stu.software.place.domain.SiteGroup;
@Repository("siteGroupDao")
public interface SiteGroupDao extends GenericDao<SiteGroup, Long>{

}
