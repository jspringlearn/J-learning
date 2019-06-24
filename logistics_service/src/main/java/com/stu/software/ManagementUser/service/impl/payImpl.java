package com.stu.software.ManagementUser.service.impl;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.ManagementUser.domain.ManagementUser_CURD;
import com.stu.software.ManagementUser.service.payManager;
import com.stu.software.order.domain.Order;
import com.stu.software.order.domain.Order_CURD;
import com.stu.software.place.domain.Site;
import com.stu.software.place.domain.SiteBaseDao;
import org.springframework.stereotype.Component;

@Component
public class payImpl implements payManager {


    @Override
    public Site findSite(int siteId) {
        Site s= SiteBaseDao.getintstan().findOne(siteId);
        //System.out.println(s);
        return s;
    }

    @Override
    public ManagementUser findManagement(int managementId) {
        ManagementUser managementUser= ManagementUser_CURD.getintstan().findOne(managementId);
        return managementUser;
    }

    @Override
    public Boss findboss(int bossId) {
        return null;
    }

    @Override
    public Order findorder(String orderId) {
        Order order= Order_CURD.getintstan().findOne(orderId);
        return order;
    }
}
