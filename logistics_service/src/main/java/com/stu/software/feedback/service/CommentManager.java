package com.stu.software.feedback.service;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
public interface CommentManager extends GenericManager<Comment, Long> {

    Comment findbyCommentID(String commentID);

}
