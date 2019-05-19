package com.stu.software.Employee.dao;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.dao.GenericTreeDaoTestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BossDaoTest extends GenericTreeDaoTestCase<Long, Boss,BossDao> {
    BossDao bossDao;
    @Autowired
    public void setBossDao(BossDao bossDao){
        this.bossDao=bossDao;
        this.dao=this.bossDao;
    }
    @Test
    public void testGetRoot(){
        int root_size=10;
        for(int i=0;i<root_size;i++){
            Boss boss=new Boss();
            boss.setBoss_name("boss_"+i);
            for(int j=0;j<10;j++) {
                Boss g=new Boss();
                g.setBoss_name("boss_"+i+"_"+j);
                g.setParent(boss);
            }
            this.bossDao.save(boss);
        }
        List<Boss> roots=this.bossDao.getRoot();
        assertEquals(root_size,roots.size());

        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Boss> roots={}", roots); //$NON-NLS-1$
        }
    }
}
