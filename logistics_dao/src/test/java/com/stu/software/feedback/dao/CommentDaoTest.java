package com.stu.software.feedback.dao;

import java.util.List;

import com.stu.software.feedback.domain.Comment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericDaoTestCase;

public class CommentDaoTest extends GenericDaoTestCase<Long, Comment, CommentDao> {

    private static final Logger logger = LogManager.getLogger(CommentDaoTest.class.getName());

    @Autowired
    CommentDao commentDao;

    @Test
    public void testGetRoot() {
        int n=2;
        for(int i = 1; i <= n; i++) {
            Comment comment = new Comment();
            comment.setCommentID("comment_"+i);
            this.commentDao.save(comment);

        }

        List<Comment> all = this.commentDao.findAll();
        if (logger.isInfoEnabled()) {
            logger.info("test() - List<comment> all size ={}", all.size()); //$NON-NLS-1$
        }

    }
}
