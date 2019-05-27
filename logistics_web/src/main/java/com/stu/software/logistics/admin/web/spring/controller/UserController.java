package com.stu.software.logistics.admin.web.spring.controller;

import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.UserManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    //bean + spring mvc 控制器
@RequestMapping("/user")
public class UserController extends GenericController<User, Long, UserManager> {

    UserManager userManager;

    @RequestMapping("/index")   //处理index的请求
    public String index() {
        return "user/index";
    }

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
        this.manager = this.userManager;
    }
}
