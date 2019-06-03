package com.stu.software.order.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.order.domain.Types;
import com.stu.software.service.GenericTreeManagerTestCase;

public class TypesManagerTest extends GenericTreeManagerTestCase<Long, Types, TypesManager> {
	  private static final Logger logger = LogManager.getLogger(TypesManagerTest.class.getName());

	   TypesManager typesManager;

	    public TypesManagerTest() {
	        super(Types.class);
	    }

	    @Autowired
	    public void setTypesManager(TypesManager typesManager) {
	        this.typesManager = typesManager;
	        this.manager = this.typesManager;
	    }

	    @Test
	    public void testSave() {
	        logger.debug("This is a test method for AOP");
	        List<Types> typesList = new ArrayList<Types>();
	        for (int i = 0;i<4;i++) {
	        	Types types = new Types();
	        	typesList.add(types);
	        }
	        this.typesManager.save(typesList);
	    }

}
