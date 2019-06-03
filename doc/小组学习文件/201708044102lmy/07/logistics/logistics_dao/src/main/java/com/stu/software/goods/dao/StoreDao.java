package com.stu.software.goods.dao;


import com.stu.software.dao.GenericTreeDao;
import com.stu.software.goods.domain.Store;
import org.springframework.stereotype.Repository;

/**
 * @Author xs
 * @Date 2019/5/18 14:02
 * @Version 1.0
 */
@Repository("storeDao")
public interface StoreDao extends GenericTreeDao<Store, Long> {

}