package com.stu.software.logistics.employee.web.spring.controller;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.employee.service.StaffManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    @RequestMapping("/allstaff")
    public String findAllStaff(Model model){
        List<Staff>staffList=this.staffManager.findAll();
        for (Staff staff:staffList){
            System.out.println(staff);
        }
        model.addAttribute("staffList",staffList);
        return "employee/list";
    }

}
