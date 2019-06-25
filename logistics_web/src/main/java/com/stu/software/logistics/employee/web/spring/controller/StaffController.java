package com.stu.software.logistics.employee.web.spring.controller;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.employee.service.StaffManager;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Staff>findAllStaff(){
        return this.staffManager.findAll();
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public  @ResponseBody
    Staff deleteone(@PathVariable(value = "id") Long id){
        Staff staff=staffManager.findById(id);
        this.staffManager.delete(id);
        return staff;
    }

    @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Staff save(Staff staff){
        this.staffManager.save(staff);
        return staff;
    }
}
