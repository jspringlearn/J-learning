package com.stu.software.logistics.managementUser.web.spring.controller;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

//    @RequestMapping("/findallmanagementUser")
//    public String findallmanagementUser(Model model) {
//        List<ManagementUser> managementUserList= this.managementUserManage.findAll();
//        model.addAttribute("managementUserList", managementUserList);
//        return "managementUser/findallmanagementUser";
//    }


    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<ManagementUser> findAllUser(){
        return this.manager.findAll();
    }

    @RequestMapping("/upd")
    public String update(ManagementUser managementUser) {
        //System.out.println(managementUser);
        this.managementUserManage.upd(managementUser);
        return "forward:findallmanagementUser.do";
    }
    @RequestMapping("/delete")
    public String delete(int managementID) {
        this.managementUserManage.deletemanagementUser(managementID);
        return "forward:findallmanagementUser";
    }
    @RequestMapping("/toupdatemanagementUser")
    public String toupdate(int managementID,Model model) {
        ManagementUser managementUser=this.managementUserManage.findone(managementID);
        model.addAttribute("managementUser", managementUser);
        return "managementUser/upd";
    }
    @RequestMapping("/toadd")
    public String toadd(){
        return "managementUser/AddmanagementUser";
    }
    @RequestMapping("/AddmanagementUser")
    public String AddmanagementUser(ManagementUser managementUser){
        ManagementUser stu=managementUserManage.save(managementUser);

        ModelAndView s=new ModelAndView();
        s.addObject(stu);
        //return managementUser;
        return "forward:findallmanagementUser.do";
    }
}



