package com.stu.software.admin.service;

import com.stu.software.admin.domain.Group;
import com.stu.software.admin.domain.User;
import com.stu.software.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminEntityGenerator extends GenericGenerator {

    @Autowired
    GroupManager groupManager;

    @Autowired
    RoleManager roleManager;

    @Autowired
    UserManager userManager;

    @Test
    public void gen_group() {
        for (int i = 0; i < 4; i++) {
            Group g = new Group();
            g.setName("group_" + i);
            this.groupManager.save(g);
            for (int j = 0; j < 4; j++) {
                Group group = new  Group();
                group.setName("group_" + i + "_" + j);
                group.setParent(g);
                g = this.groupManager.save(group);
                this.gen_user(g);
            }
        }
    }

    public void gen_user(Group g) {
        for (int i = 0; i < 4; i++) {
            User u = new User();
            u.setUsername("username_" + i);
            u.setPassword("password_" + i);
            u.setGroup(g);
            this.userManager.save(u);
        }
    }

}
