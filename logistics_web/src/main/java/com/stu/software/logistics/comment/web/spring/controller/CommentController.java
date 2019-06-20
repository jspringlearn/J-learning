package com.stu.software.logistics.comment.web.spring.controller;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.service.CommentManager;
import com.stu.software.web.spring.controller.GenericController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController extends GenericController<Comment,Long, CommentManager> {


    CommentManager commentManager;

    @Autowired
    public void setCommentManager(CommentManager commentManager) {
        this.commentManager = commentManager;
        this.manager = this.commentManager;

    }

    /**
     * test
     *
     * @return
     */
    @RequestMapping("/index")
    public String mainIndex() {
        return "main/index";
    }

    /**
     * findcomment
     */
    @RequestMapping("/findcomment")    //
    public String findAllComment(Model model) {
        List<Comment> commentList = this.commentManager.findAll();
        for (Comment comment:commentList) {
            System.out.println(comment);
        }
        model.addAttribute("commentList", commentList);
        return "comment/findcomment";
    }

    @RequestMapping("/upd")
    public String update(Comment comment) {
        this.commentManager.upd(comment);
        return "forward:findcomment.do";
    }

    @RequestMapping("/delete")
    public String delete(String commentID) {
        this.commentManager.deletecomment(commentID);
        return "forward:findcomment";
    }

    @RequestMapping("/toupdatecomment")
    public String toupdate(String commentID, Model model) {
        Comment comment = this.commentManager.findone(commentID);
        model.addAttribute("comment", comment);
        return "comment/upd";
    }

    @RequestMapping("/toadd")
    public String toadd() {
        return "comment/addcomment";
    }

    @RequestMapping("/addcomment")
    public String Addcomment(Comment comment) {
        Comment c = commentManager.save(comment);

        ModelAndView s = new ModelAndView();
        s.addObject(c);
        return "forward:findcomment.do";
    }


}
