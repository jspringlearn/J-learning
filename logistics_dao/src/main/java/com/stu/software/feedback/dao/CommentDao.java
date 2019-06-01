package com.stu.software.feedback.dao;


import com.stu.software.dao.GenericDao;
import com.stu.software.feedback.domain.Comment;
import org.springframework.stereotype.Repository;

@Repository("commentDao")
public interface CommentDao extends GenericDao<Comment,Long> {

}
