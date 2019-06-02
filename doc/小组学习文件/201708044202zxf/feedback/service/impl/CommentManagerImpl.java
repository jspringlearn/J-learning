package com.stu.software.feedback.service.impl;



import javax.transaction.Transactional;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



import com.stu.software.feedback.dao.CommentDao;

import com.stu.software.feedback.domain.Comment;

import com.stu.software.feedback.service.CommentManager;

import com.stu.software.service.impl.GenericTreeManagerImpl;



@Service("commentManager")

@Transactional



public class CommentManagerImpl extends GenericTreeManagerImpl<Comment, Long> implements CommentManager {



    CommentDao commentDao;



    @Autowired

    public void setCommentDao(CommentDao commentDao) {

        this.commentDao = commentDao;

        this.treeDao=this.commentDao;

        this.dao=this.treeDao;

    }



}
