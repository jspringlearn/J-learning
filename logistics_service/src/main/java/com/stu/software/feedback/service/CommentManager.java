package com.stu.software.feedback.service;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public interface CommentManager extends GenericManager<Comment, Long> {

    List<Comment> findbyCommentID(String commentID);
    void savecomment(String commentID,String commentContent,String commentTime);
    void deletecomment(String commentID);
    void upd(Comment comment);
    Comment findone(String commentID);

}
