package com.stu.software.logistics.goods.web.spring.controller;

import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.service.GoodsManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author xs
 * @Date 2019/5/26 15:58
 * @Version 1.0
 */
@Controller
@RequestMapping("/goods")
public class GoodsController extends GenericController<Goods, Long, GoodsManager> {

    GoodsManager goodsManager;

    @Autowired
    public void setGoodsManager(GoodsManager goodsManager) {
        this.goodsManager = goodsManager;
        this.manager = this.goodsManager;
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all", produces = "application/json;charset=utf-8")
    public List<Goods> findAllUser() {
        return this.manager.findAll();
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Goods deleteone(@PathVariable(value = "id") Long id) {
        Goods goods = goodsManager.findById(id);
        this.goodsManager.delete(id);
        return goods;
    }


    @RequestMapping(value = "save", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Goods save(Goods goods) {
        this.goodsManager.save(goods);
        return goods;
    }

    // 更改的信息还没完成。
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    public @ResponseBody
    Goods update(Goods goods) {
        Goods goods1 = this.goodsManager.findById(goods.getId());
        this.goodsManager.updateweight(goods.getId(), goods.getWeight());
        return goods1;
    }


}
