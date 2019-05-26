package com.stu.software.feedback.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.stu.software.dao.GenericTreeDaoTestCase;
import com.stu.software.feedback.domain.Comment;


public class CommentDaoTest extends GenericTreeDaoTestCase<Long,Comment,CommentDao> {
	 
	CommentDao commentDao;
	@Autowired
	public void setCommentDao(CommentDao commentDao){
        this.commentDao=commentDao;
        this.dao=this.commentDao;
    }
	@Test
    public void testGetRoot(){
        int root_size=10;
        for(int i=0;i<root_size;i++){
            Comment comment=new Comment();
            comment.setCommentSubstance("comment_"+i);
            for(int j=0;j<10;j++) {
                Comment g=new Comment();
                g.setCommentSubstance("comment_"+i+"_"+j);
                g.setParent(comment);
            }
            this.commentDao.save(comment);
        }
        List<Comment> roots=this.commentDao.getRoot();
        assertEquals(root_size,roots.size());

        if (logger.isInfoEnabled()) {
            logger.info("testGetRoot() - List<Comment> roots={}", roots); //$NON-NLS-1$
        }
    }
	
}