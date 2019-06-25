package com.stu.software.feedback.service;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public interface CommentManager extends GenericManager<Comment, Long> {

    List<Comment> findAll();
    Comment save(Comment comment);
    void delete(Long id);

    Comment findById(Long id);

}
