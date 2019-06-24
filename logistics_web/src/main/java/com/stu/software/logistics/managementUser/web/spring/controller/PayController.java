package com.stu.software.logistics.managementUser.web.spring.controller;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.service.ManagementUserManage;
import com.stu.software.employee.service.BossManager;
import com.stu.software.order.domain.Order;
import com.stu.software.order.service.OrderManager;
import com.stu.software.place.domain.Site;
import com.stu.software.place.service.SiteManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pay")
public class PayController {
//    SiteManager siteManager;
//    ManagementUserManage managementUserManage;
//    BossManager bossManager;
//    OrderManager orderManager;

    @RequestMapping("/index")
    public String mainIndex(){
        return "main/index";
    }
    @RequestMapping("/paymoney")
        public String paymoney(int siteId,int managementId,int dossId,String orderId, Model model) {
//            Site site=this.siteManager.findone(siteId);
//            ManagementUser managementUser=this.managementUserManage.findone1(managementId);
//            Order order=this.orderManager.findone(orderId);

            // model.addAttribute("site,management,order",siteId,managementId,orderId);
            return "pay/paymoney";
    }
}
