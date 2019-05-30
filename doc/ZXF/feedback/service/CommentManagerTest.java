package com.stu.software.feedback.service;

import java.util.ArrayList;

import java.util.List;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import org.junit.Test;

import org.springframework.beans.factory.annotation.Autowired;



import com.stu.software.feedback.domain.Comment;

import com.stu.software.service.GenericManagerTestCase;



public class CommentManagerTest extends GenericManagerTestCase<Long, Comment, CommentManager> {


    private static final Logger logger = LogManager.getLogger(CommentManagerTest.class.getName());



    CommentManager commentManager;



    public CommentManagerTest() {

        super(Comment.class);

    }



    @Autowired

    public void setCommentManager(CommentManager commentManager) {

        this.commentManager = commentManager;

        this.manager  = this.commentManager;

    }



    @Test

    public void testSave() {

        logger.debug("This is a test method for AOP");

        List<Comment> commentList = new ArrayList<Comment>();

        for (int i = 0;i<10;i++) {

            Comment comment = new Comment();

            commentList.add(comment);



        }

        this.commentManager.save(commentList);

    }



}
