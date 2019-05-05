package cn.gsonya.Practice.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.gsonya.Practice.admin.dao.GroupDao;
import cn.gsonya.Practice.admin.domain.Group;
import cn.gsonya.Practice.admin.service.GroupManager;
import cn.gsonya.Practice.base.service.Impl.GenericTreeManagerImpl;

@Service(value="groupManager")
public class GroupManagerImpl extends GenericTreeManagerImpl<Group, Long>implements GroupManager {
	GroupDao groupDao;
	@Autowired
	public void setGroupDao(GroupDao groupDao) {
		this.groupDao=groupDao;
		this.treeDao=this.groupDao;
		this.dao=this.treeDao;
	}

}
