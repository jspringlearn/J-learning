package com.stu.software.goods.service.impl;

import com.stu.software.admin.dao.UserDao;
import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.UserManager;
import com.stu.software.goods.dao.GoodsDao;
import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.service.GoodsManager;
import com.stu.software.service.GenericManager;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/21 10:42
 * @Version 1.0
 */
@Component
@Transactional
public class GoodsManagerlmpl extends GenericManagerImpl<Goods, Long> implements GoodsManager {

    GoodsDao goodsDao;

    @Override
    public Goods findbyGoodsname(String goodsname) {
        // TODO Auto-generated method stub
        return null;
    }

    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao=this.goodsDao;
    }
}