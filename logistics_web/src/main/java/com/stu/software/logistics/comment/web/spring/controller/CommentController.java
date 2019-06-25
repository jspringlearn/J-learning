package com.stu.software.logistics.comment.web.spring.controller;


import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.service.CommentManager;
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
@RequestMapping("/comment")
public class CommentController extends GenericController<Comment, Long, CommentManager> {

    CommentManager commentManager;

    @Autowired
    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
        this.manager=this.commentManager;
    }

    @ResponseBody//标识转换成JSON处理
    @GetMapping(value = "all",produces = "application/json;charset=utf-8")
    public List<Comment> findAllUser(){
        return this.manager.findAll();
    }


    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=utf-8")
    public @ResponseBody
    Comment deleteone(@PathVariable(value="id") Long id) {
        Comment comment=commentManager.findById(id);
        this.commentManager.delete(id);
        return comment;
    }


    @RequestMapping(value = "save",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody Comment  save(Comment comment) {
        this.commentManager.save(comment);
        return comment;
    }

    //更改的信息还没完成。
//    @RequestMapping(value = "update",method = RequestMethod.PUT,produces = "application/json;charset=utf-8")
//    public @ResponseBody Goods  update(Goods goods) {
//        Goods goods1=this.goodsManager.findById(goods.getId());
//        this.goodsManager.updateweight(goods.getId(),goods.getWeight());
//        return goods1;
//    }



}
