package com.stu.software.goods.dao;


import com.stu.software.goods.domain.Goods;

import com.stu.software.dao.GenericDaoTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/18 15:16
 * @Version 1.0
 */
public class GoodsDaotest extends GenericDaoTestCase<Long, Goods, GoodsDao> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(GoodsDaotest.class.getName());

    @Autowired
    GoodsDao goodsDao;

    @Test
        public void testGetRoot() {
           int n=2;
            for(int i = 1; i <= n; i++) {
                Goods goods = new Goods();
                goods.setName("goods_" + i);
                goods.setName("goods_" + i);
                this.goodsDao.save(goods);
            }

        List<Goods> all = this.goodsDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("test() - List<goods> all size ={}", all.size()); //$NON-NLS-1$
        }

        }

    }

