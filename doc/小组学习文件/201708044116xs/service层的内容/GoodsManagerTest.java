package com.stu.software.goods.service;

import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.UserManager;
import com.stu.software.admin.service.UserManagerTest;
import com.stu.software.goods.domain.Goods;
import com.stu.software.service.GenericManagerTestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/20 20:39
 * @Version 1.0
 */
public class GoodsManagerTest  extends GenericManagerTestCase<Long, Goods, GoodsManager> {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(GoodsManagerTest.class.getName());

    GoodsManager goodsManager;

    public GoodsManagerTest() {
        super(Goods.class);
    }

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
        this.manager = this.goodsManager;
    }

    @Test
    public void testSave() {
        logger.debug("This is a test method for AOP");
        List<Goods> goodsList = new ArrayList<Goods>();
        for (int i = 0;i<10;i++) {
            Goods goods = new Goods();
            goodsList.add(goods);

        }
        this.goodsManager.save(goodsList);
    }

}