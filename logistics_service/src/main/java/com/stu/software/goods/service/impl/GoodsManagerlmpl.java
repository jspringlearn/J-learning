package com.stu.software.goods.service.impl;

import com.stu.software.goods.dao.GoodsDao;
import com.stu.software.goods.domain.Goods;
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



    @Override
    public List<Goods> findAll()
    {
        return goodsDao.findAll();
    }

    @Override
    public Goods save (Goods goods)
    {
        return goodsDao.save(goods);
    }


    @Override
    public void delete(Long id) {
        this.goodsDao.deleteById(id);
    }

    @Override
    public Goods findById(Long id)
    {
          return goodsDao.getOne(id);
    }

//    public void updateweight(Long id,double weight)  //这里的封装类与数值类的区别,与用Double的区别
//    {
//        Goods goods=dao.getOne(id);
//        goods.setWeight(weight);
//    }
}