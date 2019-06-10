package com.stu.software.goods.service;

import com.stu.software.goods.domain.Goods;
import com.stu.software.place.domain.Site;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/20 20:41
 * @Version 1.0
 */

@Component
@Transactional
public interface GoodsManager  extends GenericManager<Goods, Long> {

    List<Goods> findAll();
    void savegoods(String name,String number);
    void deletegoods(long goodsId);
    void update(Goods goods);
    Goods findone(long goodsId);
    Goods findbyGoodsname(String goodsname);



}
