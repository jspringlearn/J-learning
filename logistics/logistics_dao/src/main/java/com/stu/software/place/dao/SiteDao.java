package com.stu.software.place.dao;

import org.springframework.stereotype.Repository;

import com.stu.software.dao.GenericDao;
import com.stu.software.place.domain.Site;
@Repository("siteDao")
public interface SiteDao extends GenericDao<Site, Long> {

}
