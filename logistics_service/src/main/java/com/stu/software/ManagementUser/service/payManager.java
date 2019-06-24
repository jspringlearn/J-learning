package com.stu.software.ManagementUser.service;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.order.domain.Order;
import com.stu.software.place.domain.Site;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public interface payManager {

    Site findSite(int siteId);
    ManagementUser findManagement(int managementId);
    Boss findboss(int bossId);
    Order findorder(String orderId);


}
