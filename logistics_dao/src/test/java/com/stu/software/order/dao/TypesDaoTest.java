package com.stu.software.order.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.order.domain.Types;



public class TypesDaoTest extends GenericTreeDaoTestCase<Long, Types, TypesDao> {
	
	 /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(TypesDaoTest.class.getName());

    @Autowired
    TypesDao typesdao;


    @Test
    public void testGetRoot() {
        int n=2;
        for(int i = 0; i < n; i++) {
            Types types = new Types();
            types.setName("types_" + i);
            this.typesdao.save(types);
        }

        List<Types> roots = this.typesdao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<types> roots={}", roots); //$NON-NLS-1$
        }

    }
}