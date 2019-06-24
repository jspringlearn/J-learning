package com.stu.software.logistics.employee.web.spring.controller;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.employee.service.StaffManager;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gsonya
 * @title
 * @Package com.stu.software.logistics.employee.web.spring.controller
 * @date 2019/6/13 11:42
 */
@Controller
@RequestMapping("/employee")
public class StaffController extends GenericController<Staff, Long, StaffManager> {
    private StaffManager staffManager;
    @Autowired
    public void setStaffManager(StaffManager staffManager){
        this.staffManager=staffManager;
        this.manager=this.staffManager;
    }
    //显示所有员工信息
//    @RequestMapping("/allstaff")
//    public String findAllStaff(Model model){
//        List<Staff>staffList=this.staffManager.findAll();
//        for (Staff staff:staffList){
//            System.out.println(staff);
//        }
//        model.addAttribute("staffList",staffList);
//        return "employee/list";
//    }


    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Staff> findAllUser(){
        return this.manager.findAll();
    }

    @RequestMapping("upd")
    public String update(Staff staff){
        this.staffManager.upd(staff);
        return "forward:allstaff.do";
    }



    @RequestMapping("/toupdatestaff")
    public String toupdate(long id,Model model){
        Staff staff=this.staffManager.findById(id);

        model.addAttribute("staff",staff);
        return "employee/upd";
    }
    @RequestMapping("/delete")
    public String delete(long id){
        this.staffManager.delete(id);
        return "forward:allstaff";
    }


    @RequestMapping("/tosave")
    public String tosaveStaff(){
        return "employee/add";
    }
    @RequestMapping("/save")
    public String saveStaff(Staff staff){
        this.staffManager.save(staff);
        return "forward:allstaff";
    }


}
