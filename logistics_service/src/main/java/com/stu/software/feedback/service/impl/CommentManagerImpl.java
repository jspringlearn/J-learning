package com.stu.software.feedback.service.impl;

import javax.transaction.Transactional;

import com.stu.software.feedback.dao.CommentDao;
import com.stu.software.feedback.domain.Comment;
import com.stu.software.feedback.domain.Comment_CURD;
import com.stu.software.feedback.service.CommentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.service.impl.GenericManagerImpl;

import java.util.List;


@Component
@Transactional
public class CommentManagerImpl extends GenericManagerImpl<Comment, Long> implements CommentManager{

    CommentDao commentDao;

    @Autowired
    public void setCommentDao(CommentDao commentDao)
    {
        this.commentDao =commentDao;
        this.dao=this.commentDao;
    }
    /**
     * findbyCommentID
     *
     * **/
    @Override
    public List<Comment> findbyCommentID(String commentID){
        List<Comment> all=Comment_CURD.getintstan().findAll();
        return all;
    }

    /**
     * save
     *
     * **/
    @Override
    public void savecomment(String commentID,String commentContent, String commentTime) {
        // TODO Auto-generated method stub
        Comment comment=new Comment();
        comment.setCommentID(commentID);
        comment.setCommentContent(commentContent);
        comment.setCommentTime(commentTime);
        this.commentDao.save(comment);

    }

    /**
     * delete
     *
     * **/

    @Override
    public void deletecomment(String commentID) {
        // TODO Auto-generated method stub
        Comment_CURD.getintstan().del(commentID);

    }

    /**
     * update
     *
     * **/
    @Override
    public void upd(Comment comment) {
        // TODO Auto-generated method stub
        Comment_CURD.getintstan().upd(comment);

    }

    /**
     * findone
     *
     * **/
    @Override
    public Comment findone(String commentID) {
        // TODO Auto-generated method stub
        Comment c=Comment_CURD.getintstan().findOne(commentID);
        return c;
    }


}
