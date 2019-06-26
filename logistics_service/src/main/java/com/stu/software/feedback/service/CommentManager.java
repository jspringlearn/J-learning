package com.stu.software.feedback.service;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public interface CommentManager extends GenericManager<Comment, Long> {
    /*
     * 罗列出所有评论的信息
     *
     * */
    List<Comment> findAll();
    /*
     * 保存评论信息
     *
     * */
    Comment save(Comment comment);
    /*
     * 根据id删除评论
     *
     * */
    void delete(Long id);
    /*
     * 根据id查找某条评论
     *
     * */
    Comment findById(Long id);

}
