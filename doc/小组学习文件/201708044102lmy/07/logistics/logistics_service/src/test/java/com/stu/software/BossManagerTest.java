package com.stu.software;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.employee.service.BossManager;
import com.stu.software.service.GenericTreeManagerTestCase;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software
 * @date 2019/5/20 15:59
 */
public class BossManagerTest extends GenericTreeManagerTestCase<Long, Boss, BossManager> {
    BossManager bossManager;
    public BossManagerTest() {
        super(Boss.class);
    }
    @Autowired
    public void setBossManager(BossManager bossManager) {
        this.bossManager=bossManager;
        this.manager=this.bossManager;
    }
    @Test
    //@Commit
    public void testAddBoss() {
        for(int i=0;i<10;i++) {
            Boss boss=new Boss();
            boss.setBoss_name("Boss_"+i);
            boss=this.bossManager.save(boss);
            for(int j=0;j<10;j++) {
                Boss subBoss=new Boss();
                subBoss.setBoss_name("subBoss_"+i+"_"+j);
                subBoss.setParent(boss);
                subBoss=this.bossManager.save(subBoss);
            }
        }
        List<Boss> rootBossList=this.bossManager.getRoot();
        assertNotNull(rootBossList);
        //assertEquals(10,rootBossList.size());
        TestCase.assertEquals(10,rootBossList.size());
    }
}
