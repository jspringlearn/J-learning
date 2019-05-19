package com.stu.software.goods.dao;

import com.stu.software.goods.domain.Goods;
import com.stu.software.dao.GenericDao;
import org.springframework.stereotype.Repository;

/**
 * @Author xs
 * @Date 2019/5/18 13:49
 * @Version 1.0
 */
@Repository("goodsDao")
public interface GoodsDao extends GenericDao<Goods, Long> {

}