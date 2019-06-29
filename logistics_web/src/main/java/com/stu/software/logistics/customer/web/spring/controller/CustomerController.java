package com.stu.software.logistics.customer.web.spring.controller;

import com.alibaba.fastjson.JSONObject;
import com.stu.software.customer.domain.Customer;
import com.stu.software.customer.service.CustomerManage;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/managementUser")
public class CustomerController extends GenericController<Customer, Long, CustomerManage> {

    CustomerManage customerManage;

    @Autowired
    public void setCustomerManage(CustomerManage customerManage) {
        this.customerManage = customerManage;
        this.manager = this.customerManage;
    }

    @RequestMapping("/index")
    public String mainIndex() {
        return "main/index";
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public List<Customer> findAllUser() {
        return this.manager.findAll();
    }


    @RequestMapping("/toadd")
    public String toadd() {
        return "managementUser/AddmanagementUser";
    }

    @RequestMapping("/AddmanagementUser")
    public String AddmanagementUser(Customer customer) {
        Customer stu = customerManage.save(customer);

        ModelAndView s = new ModelAndView();
        s.addObject(stu);
        return "forward:findallmanagementUser.do";
    }


    @ResponseBody
    @PostMapping(value = "update", produces = "application/json;charset=utf-8")
    public Boolean update(@RequestBody String msg) {
        Customer customerUpdate = JSONObject.parseObject(msg, Customer.class);
        Customer customer = this.manager.findById(customerUpdate.getId());
        customer.setMName(customerUpdate.getMName());
        customer.setMPhone(customerUpdate.getMPhone());
        customer.setDateModified(new Date());
        this.manager.save(customer);
        return true;
    }


    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Customer save(Customer customer) {

        this.customerManage.save(customer);
        return customer;
    }

    @ResponseBody
    @GetMapping(value = "id/{id}", produces = "application/json;charset=utf-8")
    public Customer getManagementUser(@PathVariable("id") Long id) {
        Customer result = this.customerManage.findById(id);
        return result;
    }

    @ResponseBody
    @GetMapping(value = "sno/{sno}", produces = "application/json;charset=utf-8")
    public List<Customer> getManagement(@PathVariable int sno) {
        return this.customerManage.findBySno(sno);
    }


    @DeleteMapping(value = "deleteById/{id}", produces = "application/json;charset=utf-8")
    public @ResponseBody
    Customer deleteById(@PathVariable(value = "id") Long id) {
        Customer customer = this.customerManage.findById(id);
        this.customerManage.deleteById(id);
        return customer;
    }

}



