package com.stu.software.logistics.goods.web.spring.controller;

import com.stu.software.goods.domain.Goods;
import com.stu.software.goods.service.GoodsManager;
import com.stu.software.place.domain.Site;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    }


    @RequestMapping("/allgoods")    //  显示所有  allsite
    public String findAllSite(Model model) {
        List<Goods> goodsList= this.goodsManager.findAll();
        for(Goods goods:goodsList) {
          //  System.out.println(goods);
        }
        model.addAttribute("goodsList", goodsList);
        return "goods/findall";
    }

    @RequestMapping("/update")
    public String update(Goods goods) {
        System.out.println(goods);
        this.goodsManager.update(goods);
        return "forward:allgoods";    //turn to 方法的allsite
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
}
