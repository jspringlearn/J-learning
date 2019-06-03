package com.stu.software.order.service.impl;


import org.springframework.beans.factory.annotation.Autowired;


import com.stu.software.order.dao.TypesDao;
import com.stu.software.order.domain.Types;
import com.stu.software.order.service.TypesManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;


@Component
@Transactional
public class TypesManagerImpl extends GenericTreeManagerImpl<Types, Long> implements TypesManager {

	
	
	TypesDao typesDao;
	

	@Autowired
	public void setTypesDao(TypesDao typesDao) {
		this.typesDao = typesDao;
		this.treeDao=this.typesDao;
		this.dao=this.treeDao;
		
	}
}
