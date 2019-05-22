package com.stu.software.goods.service.impl;

import com.stu.software.admin.dao.GroupDao;
import com.stu.software.goods.dao.StoreDao;
import com.stu.software.goods.domain.Store;
import com.stu.software.goods.service.StoreManager;
import com.stu.software.service.impl.GenericTreeManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * @Author xs
 * @Date 2019/5/21 10:49
 * @Version 1.0
 */

@Component
@Transactional
public class StoreManagerlmpl  extends GenericTreeManagerImpl<Store, Long> implements StoreManager {


    StoreDao storeDao;
    @Autowired
    public void setStoreDao(StoreDao storeDao) {
        this.storeDao = storeDao;
        this.treeDao=this.storeDao;
        this.dao=this.treeDao;
    }
}