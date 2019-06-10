package com.stu.software.admin.service.impl;


import com.stu.software.admin.dao.GroupDao;
import com.stu.software.admin.domain.Group;
import com.stu.software.admin.service.GroupManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 *
 *
 */
@Service("groupManager")  //将groupManager 标为一个服务层的bean
@Transactional
public class GroupManagerImpl extends GenericTreeManagerImpl<Group, Long> implements GroupManager {

	GroupDao groupDao;
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
		this.treeDao = this.groupDao;
		this.dao = this.treeDao;
	}
	
	
}
