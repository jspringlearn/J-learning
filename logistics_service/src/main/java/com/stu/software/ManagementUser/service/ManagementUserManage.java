package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
@Transactional
public interface ManagementUserManage extends GenericManager<ManagementUser,Long> {
    /*
    *
    * 根据姓名查找管理员
    * */
    List<ManagementUser> findByManagementUserName(String ManagementName);
}
