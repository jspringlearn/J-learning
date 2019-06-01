package com.stu.software.feedback.service;

import java.util.ArrayList;
import java.util.List;

import com.stu.software.feedback.domain.Ctype;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.service.GenericTreeManagerTestCase;

public class CtypeManagerTest extends GenericTreeManagerTestCase<Long, Ctype, CtypeManager> {
    private static final Logger logger = LogManager.getLogger(CtypeManagerTest.class.getName());


    CtypeManager ctypeManager;

    public CtypeManagerTest() {
        super(Ctype.class);
    }

    @Autowired
    public void setCtypeManager(CtypeManager ctypeManager) {
        this.ctypeManager = ctypeManager;
        this.manager = this.ctypeManager;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<Ctype> ctypeList = new ArrayList<Ctype>();
        for (int i = 0;i<4;i++) {
            Ctype ctype = new Ctype();
            ctypeList.add(ctype);
        }
        this.ctypeManager.save(ctypeList);
    }

}
