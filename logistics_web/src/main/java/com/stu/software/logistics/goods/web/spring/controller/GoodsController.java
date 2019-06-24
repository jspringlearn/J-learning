package com.stu.software.logistics.goods.web.spring.controller;

import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.service.GoodsManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        this.manager=this.goodsManager;
    }


//    @RequestMapping("/allgoods")    //  显示货物
//    public String findAllSite(Model model) {
//        List<Goods> goodsList= this.goodsManager.findAll();
//        for(Goods goods:goodsList) {
//          //  System.out.println(goods);
//        }
//        model.addAttribute("goodsList", goodsList);
//        return "goods/findall";
//    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Goods> findAllUser(){
        return this.manager.findAll();
    }

    @RequestMapping("/update")
    public String update(Goods goods) {
        System.out.println(goods);
        this.goodsManager.update(goods);
        return "forward:allgoods";    //转向方法
    }
    @RequestMapping("/toupdategoods")
    public String toupdate(long goodsId,Model model) {
        Goods goods=this.goodsManager.findone(goodsId);
//        System.out.println(goods);
//		Model model=new Model();
        model.addAttribute("goods", goods);
        return "goods/update";
    }
    @RequestMapping("/delete")
    public String delete(long goodsId) {
        this.goodsManager.deletegoods(goodsId);
        return "forward:allgoods";
    }
    @RequestMapping("/add")
    public String addsome() {
        return "goods/addsome";
    }

    @RequestMapping("/save")
    public String savesome(Goods goods) {
        this.goodsManager.save(goods);
        return "forward:allgoods";
    }
}
