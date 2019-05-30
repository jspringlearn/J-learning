package com.stu.software.feedback.service;


import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;



import com.stu.software.feedback.domain.Comment;

import com.stu.software.service.GenericGenerator;



public class FeedbackEntityGenerator extends GenericGenerator {



    @Autowired

    CommentManager commentManager;



    @Test

    public void gen_comment() {

        for (int i = 0; i <4; i++) {

            Comment g = new Comment();

            g.getId();

            this.commentManager.save(g);

        }

    }





}
