package com.stu.software.logistics.goods.web.spring.controller;

import com.stu.software.admin.domain.User;
import com.stu.software.admin.service.UserManager;
import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.service.GoodsManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author xs
 * @Date 2019/5/26 15:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends GenericController<Goods, Long, GoodsManager> {

    GoodsManager goodsManager;

    @RequestMapping("/index")   //处理index的请求
    public String index() {
        return "goods/index";
    }

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
    }

}
