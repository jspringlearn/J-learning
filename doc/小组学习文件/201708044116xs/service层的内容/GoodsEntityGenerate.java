package com.stu.software.goods.service;

import com.stu.software.admin.domain.Group;
import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.GroupManager;
import com.stu.software.admin.service.RoleManager;
import com.stu.software.admin.service.UserManager;
import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.domain.Store;
import com.stu.software.service.GenericGenerator;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author xs
 * @Date 2019/5/21 10:59
 * @Version 1.0
 */
public class GoodsEntityGenerate extends GenericGenerator {

    @Autowired
    StoreManager storeManager;
    @Autowired
    GoodsManager goodsManager;



    @Test
    public void gen_store() {
        for (int i = 0; i < 4; i++) {
            Store s =new Store();
            s.setName("store_" + i);
            this.storeManager.save(s);
            for (int j = 0; j < 4; j++) {
                Store store = new Store();
                store.setName("store_" + i + "_" + j);
                store.setParent(s);
                s = this.storeManager.save(store);
                this.gen_goods(s);
            }
        }
    }

    public void gen_goods(Store s) {
        for (int i = 0; i <4; i++) {
            Goods g = new Goods();
            g.setName("goods_i");
            g.setStore(s);
            this.goodsManager.save(g);
        }
    }

}