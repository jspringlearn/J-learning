package com.stu.software.ManagementUser.service;

import com.stu.software.ManagementUser.domain.ManagementUser;
import com.stu.software.service.GenericManager;
import com.stu.software.service.GenericTreeManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ManagementUserManage extends GenericManager<ManagementUser,Long> {
    /*
    *
    * 根据姓名查找管理员
    * */
    List<ManagementUser> findByManagementUserName(String ManagementName);
}
