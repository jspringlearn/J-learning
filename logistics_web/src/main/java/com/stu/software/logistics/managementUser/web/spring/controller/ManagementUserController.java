package com.stu.software.logistics.managementUser.web.spring.controller;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/managementUser")
public class ManagementUserController extends GenericController<ManagementUser,Long, ManagementUserManage>{

    ManagementUserManage managementUserManage;

    @Autowired
    public void setManagementUserManage(ManagementUserManage managementUserManage) {
        this.managementUserManage = managementUserManage;
        this.manager=this.managementUserManage;
    }

    @RequestMapping("/index")
    public String mainIndex(){
        return "main/index";
    }

    @RequestMapping("/findallmanagementUser")    //  /allsite
    public String findallmanagementUser(Model model) {
        List<ManagementUser> managementUserList= this.managementUserManage.findAll();
//        for(ManagementUser managementUser:managementUserList) {
//            System.out.println(managementUser);
//        }
        model.addAttribute("managementUserList", managementUserList);
        return "managementUser/findallmanagementUser";
    }
    @RequestMapping("AddManagementuser")
    public String AddmanagementUser(Model model){
        ManagementUser managementUser;

        return "managementUser/AddManagementuser";
    }

    @RequestMapping("findByName")
    public String findByName(Model model){
//        List<ManagementUser> managementUserList= this.managementUserManage.findAll();
//        for(ManagementUser managementUser:managementUserList) {
//
//            System.out.println(managementUser);
//        }
//        model.addAttribute("managementUserList", managementUserList);
        return "managementUser/findByName";
    }

}



