package com.stu.software.employee.service;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.Employee.domain.Staff;
import com.stu.software.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.employee.service
 * @date 2019/5/28 21:10
 */
public class EmployeeEntityGenerate extends GenericGenerator {
    @Autowired
    BossManager bossManager;
    @Autowired
    StaffManager staffManager;
    @Test
    public void gen_boss(){
        for(int i=0;i<4;i++){
            Boss g=new Boss();
            g.setBoss_name("boss_"+i);
            this.bossManager.save(g);
            for(int j=0;j<4;j++){
                Boss boss=new Boss();
                boss.setBoss_name("boss_"+i+"_"+j);
                boss.setParent(g);
                g=this.bossManager.save(boss);
                this.gen_staff(g);
            }
        }
    }
    public void gen_staff(Boss g){
        for (int i=0;i<4;i++){
            Staff u=new Staff();
            u.setStaff_name("staffname_"+i);
            u.setBoss(g);
            this.staffManager.save(u);
        }
    }
}
