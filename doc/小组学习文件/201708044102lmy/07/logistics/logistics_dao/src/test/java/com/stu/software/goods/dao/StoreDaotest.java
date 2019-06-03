package com.stu.software.goods.dao;

import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.goods.domain.Store;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/18 15:39
 * @Version 1.0
 */
public class StoreDaotest extends GenericTreeDaoTestCase<Long, Store, StoreDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(StoreDaotest.class.getName());

    @Autowired
    StoreDao storedao;


    @Test
    public void testGetRoot() {
        int n=2;
        for(int i = 0; i < n; i++) {
            Store store = new Store();
            store.setName("store_" + i);
            this.storedao.save(store);
        }

        List<Store> roots = this.storedao.getRoot();
        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<store> roots={}", roots); //$NON-NLS-1$
        }

    }
}