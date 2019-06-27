package com.stu.software.logistics.customer.web.spring.controller;

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
    public String mainIndex() {
        return "main/index";
    }

    @RequestMapping("/paymoney")
    public String paymoney(int siteId, int managementId, int dossId, String orderId, Model model) {
//            Site site=this.siteManager.findone(siteId);
//            Customer managementUser=this.managementUserManage.findone1(managementId);
//            Order order=this.orderManager.findone(orderId);

        // model.addAttribute("site,management,order",siteId,managementId,orderId);
        return "pay/paymoney";
    }
}
