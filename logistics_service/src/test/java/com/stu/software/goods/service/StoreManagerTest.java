package com.stu.software.goods.service;

import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.domain.Store;
import com.stu.software.service.GenericManagerTestCase;
import com.stu.software.service.GenericTreeManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/21 13:27
 * @Version 1.0
 */
public class StoreManagerTest extends GenericTreeManagerTestCase<Long, Store, StoreManager> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(GoodsManagerTest.class.getName());

    StoreManager storeManager;

    public StoreManagerTest() {
        super(Store.class);
    }

    @Autowired
    public void setStoreManager(StoreManager storeManager) {
        this.storeManager = storeManager;
        this.manager = this.storeManager;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<Store> storeList = new ArrayList<Store>();
        for (int i = 0;i<4;i++) {
            Store store = new Store();
            storeList.add(store);
        }
        this.storeManager.save(storeList);
    }

}