package com.stu.software.logistics.managementUser.web.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.*;
=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
>>>>>>> bad9b60eaf47e9ea582e83130e681f212fcc546f
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/managementUser")
public class ManagementUserController extends GenericController<ManagementUser,Long, ManagementUserManage> {

    ManagementUserManage managementUserManage;

    @Autowired
    public void setManagementUserManage(ManagementUserManage managementUserManage) {
        this.managementUserManage = managementUserManage;
        this.manager = this.managementUserManage;
    }

    @RequestMapping("/index")
    public String mainIndex() {
        return "main/index";
    }

<<<<<<< HEAD
  /*  @RequestMapping("/findallmanagementUser")
    public String findallmanagementUser(Model model) {
        List<ManagementUser> managementUserList= this.managementUserManage.findAll();
        model.addAttribute("managementUserList", managementUserList);
        return "managementUser/findallmanagementUser";
    }*/

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public List<ManagementUser> findAllUser() {
=======
//    @RequestMapping("/findallmanagementUser")
//    public String findallmanagementUser(Model model) {
//        List<ManagementUser> managementUserList= this.managementUserManage.findAll();
//        model.addAttribute("managementUserList", managementUserList);
//        return "managementUser/findallmanagementUser";
//    }


    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<ManagementUser> findAllUser(){
>>>>>>> bad9b60eaf47e9ea582e83130e681f212fcc546f
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
    public String toupdate(int managementID, Model model) {
        ManagementUser managementUser = this.managementUserManage.findone1(managementID);
        model.addAttribute("managementUser", managementUser);
        return "managementUser/upd";
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "managementUser/AddmanagementUser";
    }

    @RequestMapping("/AddmanagementUser")
    public String AddmanagementUser(ManagementUser managementUser) {
        ManagementUser stu = managementUserManage.save(managementUser);

        ModelAndView s = new ModelAndView();
        s.addObject(stu);
        //return managementUser;
        return "forward:findallmanagementUser.do";
    }


    @ResponseBody
    @PostMapping(value = "update", produces = "application/json;charset=utf-8")
    public Boolean update(@RequestBody String msg) {
        ManagementUser managementUserUpdate = JSONObject.parseObject(msg, ManagementUser.class);
        ManagementUser managementUser = this.manager.findById(managementUserUpdate.getId());
        managementUser.setManagementID(managementUserUpdate.getManagementID());
        managementUser.setMName(managementUserUpdate.getMName());
        managementUser.setMPhone(managementUserUpdate.getMPhone());
        managementUser.setDateModified(new Date());
        this.manager.save(managementUser);
        return true;
    }


    @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public  @ResponseBody ManagementUser save(ManagementUser managementUser) {
      //  ManagementUser managementUser = JSONObject.parseObject(msg, ManagementUser.class);
        this.managementUserManage.save(managementUser);
      //  System.out.println(managementUser);
        return managementUser;
    }
    @ResponseBody
    @GetMapping(value = "id/{id}",produces = "application/json;charset=utf-8")
    public ManagementUser getManagementUser(@PathVariable("id") Long id) {
        ManagementUser result = this.managementUserManage.findById(id);
        return result;
    }
    @ResponseBody
    @GetMapping(value = "sno/{sno}",produces = "application/json;charset=utf-8")
    public List<ManagementUser> getManagement(@PathVariable int sno) {
      return this.managementUserManage.findBySno(sno);
    }


    @DeleteMapping(value = "deleteById/{id}", produces = "application/json;charset=utf-8")
    public @ResponseBody ManagementUser deleteById(@PathVariable(value = "id")Long id) {
        ManagementUser managementUser=this.managementUserManage.findById(id);
        this.managementUserManage.deleteById(id);
        return managementUser;
    }

}



