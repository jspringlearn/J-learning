package com.stu.software.logistics.feedback.web.spring.controller;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.service.CommentManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/comment")

public class CommentController extends GenericController<Comment,Long, CommentManager> {
    CommentManager commentManager;
    @Autowired
    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
        this.manager=this.commentManager;
    }
    @RequestMapping("/index")
    public String mainIndex(){
        return "main/index";
    }

    @RequestMapping("/allcomment")
    public String findAllComment(Model model){
        List<Comment> commentList=this.commentManager.findAll();
        for(Comment comment:commentList){
            System.out.println(comment);
        }

        model.addAttribute("commentList", commentList);
        return "comment/findallcomment";
    }
    @RequestMapping("/upd")
    public String update(Comment comment) {
        //System.out.println(comment);
        this.commentManager.upd(comment);

        return "forward:allcomment.do";
    }
    @RequestMapping("/delete")
    public String delete(String commentId){
        this.commentManager.deletecomment(commentId);
        return "forward:allcomment";
    }
    @RequestMapping("/toupdatecomment")
    public String toupdate(String commentId,Model model) {
        Comment comment=this.commentManager.findone(commentId);
//        System.out.println(comment);
//		Model model=new Model();
        model.addAttribute("comment", comment);
        return "comment/update";
    }

}
