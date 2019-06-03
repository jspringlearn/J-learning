package com.stu.software.logistics.employee.web.spring.controller;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.employee.service.StaffManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.logistics.employee.web.spring.controller
 * @date 2019/6/3 16:20
 */
@Controller
@RequestMapping(value = "staff")
public class StaffController {
    private StaffManager staffManager;
    @Autowired
    public void setStaffManager(StaffManager staffManager) {
        this.staffManager=staffManager;
    }

    @ResponseBody
    @GetMapping(value = "getAll",produces = "application/json;charset=UTF-8")
    public List<Staff> getAllStaff(){

        return staffManager.getAll();
    }

}
