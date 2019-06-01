package com.stu.software.feedback.dao;

import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.feedback.domain.Ctype;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CtypeDaoTest extends GenericTreeDaoTestCase<Long, Ctype,CtypeDao> {


    CtypeDao ctypeDao;
    @Autowired
    public void setCtypeDao(CtypeDao ctypeDao) {
        this.ctypeDao = ctypeDao;
        this.dao=this.ctypeDao;
    }
    @Test
    public void testGetRoot(){
        int root_size=10;
        for(int i=0;i<root_size;i++){
            Ctype ctype=new Ctype();
            ctype.setCtypeName("ctype_"+i);
            for(int j=0;j<10;j++) {
                Ctype g=new Ctype();
                g.setCtypeName("ctype_"+i+"_"+j);
                g.setParent(ctype);
            }
            this.ctypeDao.save(ctype);
        }
        List<Ctype> roots=this.ctypeDao.getRoot();
        assertEquals(root_size,roots.size());

        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Boss> roots={}", roots); //$NON-NLS-1$
        }
    }
}