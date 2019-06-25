package com.stu.software.feedback.service.impl;

import javax.transaction.Transactional;

import com.stu.software.feedback.dao.CommentDao;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.service.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.service.impl.GenericManagerImpl;

import java.util.List;


@Component
@Transactional
public class CommentManagerImpl extends GenericManagerImpl<Comment, Long> implements CommentManager {

    CommentDao commentDao;

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
        this.dao = this.commentDao;
    }

    /**
     * findbyCommentID
     **/
    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentDao.save(comment);
    }


    @Override
    public void delete(Long id) {
        this.commentDao.deleteById(id);
    }

    @Override
    public Comment findById(Long id) {
        return commentDao.getOne(id);
    }
}
