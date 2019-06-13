package com.stu.software.goods.service.impl;

import com.stu.software.goods.dao.GoodsDao;
import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.domain.Goods_CURD;
import com.stu.software.goods.service.GoodsManager;
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

    @Autowired
    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
        this.dao=this.goodsDao;
    }

    /**
     * find all site
     */
    @Override
    public List<Goods> findAll() {
        // TODO Auto-generated method stub
        List<Goods> all = Goods_CURD.getintstan().findAll();
        return all;
    }

    @Override
    public Goods findbyGoodsname(String goodsname) {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public Goods findone(long goodsId) {
        // TODO Auto-generated method stub
        Goods goods=new Goods();
        goods=Goods_CURD.getintstan().findOne(goodsId);
       // System.out.println(goods);
        return goods;
    }


    @Override
    public void savegoods(String name,String number) {
        // TODO Auto-generated method stub
        Goods goods = new Goods();
        goods.setName(name);
        goods.setNumber(number);
        this.goodsDao.save(goods);
    }


    /**
     * update
     */
    @Override
    public void update(Goods goods) {
        // TODO Auto-generated method stub
        Goods_CURD.getintstan().upd(goods);

    }

    /**
     * delete Site
     */
    @Override
    public void deletegoods(long goodsId) {
        // TODO Auto-generated method stub
        Goods_CURD.getintstan().del(goodsId);
    }
}