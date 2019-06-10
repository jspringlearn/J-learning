package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.domain.ManagementUserGroup;
import com.stu.software.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ManagementUserEntityGenerator extends GenericGenerator {

    @Autowired
    ManagementUserManage managementUserManage;

    @Autowired
    ManagementUserGroupManage managementUserGroupManage;

    @Test
    public void gen_ManagementUserGroup(){
        for(int i=0;i<3;i++){
            ManagementUserGroup MUG=new ManagementUserGroup();
            MUG.setManagementName("ManagementName"+i);
            MUG.setCommonManagementName("CommonManagementName"+i);
            this.managementUserGroupManage.save(MUG);
            for(int j=0;j<5;j++){
                ManagementUserGroup m=new ManagementUserGroup();
                m.setManagementName("ManagementName"+i+"_"+j);
                m.setCommonManagementName("CommonManagementName"+i+"_"+j);
                m.setManagementID("ManagementID"+i+j+j+j+j+j+j);
                m.setCommonManagementID("CommonManagementID"+i+i+j+j+j+j+j+j+j);
                m.setParent(MUG);
                MUG=this.managementUserGroupManage.save(m);
                this.gen_ManagementUser(MUG);
            }
        }
    }
    public void gen_ManagementUser(ManagementUserGroup managementUserGroup){
        for(int i=0;i<3;i++){
            ManagementUser managementUser=new ManagementUser();
            managementUser.setMName("Management"+i);
            managementUser.setMPhone("Management"+i+i+i+i+i+i);
            this.managementUserManage.save(managementUser);
        }
    }
}
