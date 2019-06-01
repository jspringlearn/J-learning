package com.stu.software.feedback.service.impl;

import javax.transaction.Transactional;

import com.stu.software.feedback.dao.CommentDao;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.service.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.service.impl.GenericManagerImpl;


@Component
@Transactional

public class CommentManagerImpl extends GenericManagerImpl<Comment, Long> implements CommentManager {



    CommentDao commentDao;

    @Override
    public Comment findbyCommentID(String commentID) {
        return null;
    }


    @Autowired

        public void setCommentDao (CommentDao commentDao){

            this.commentDao = commentDao;

            this.dao = this.commentDao;

        }

    }



