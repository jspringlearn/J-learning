package com.stu.software.admin.service.impl;

import com.stu.software.Employee.dao.BossDao;
import com.stu.software.Employee.domain.Boss;
import com.stu.software.admin.service.BossManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.admin.service.impl
 * @date 2019/5/20 15:50
 */
@Service("BossManager")
public class BossManagerImpl extends GenericTreeManagerImpl<Boss, Long> implements BossManager {
    BossDao bossDao;
    @Autowired
    public void setBossDao(BossDao bossDao) {
        this.bossDao=bossDao;
        this.treeDao=this.bossDao;
        this.dao=this.treeDao;
    }

}
