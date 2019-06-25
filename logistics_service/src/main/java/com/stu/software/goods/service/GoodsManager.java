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
    Goods save(Goods goods);
    void delete(Long id);
    Goods findById(Long id);
   // void updateweight(Long id,double weight);

}
