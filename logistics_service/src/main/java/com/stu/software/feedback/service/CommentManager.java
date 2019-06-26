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
     * ���г��������۵���Ϣ
     *
     * */
    List<Comment> findAll();
    /*
     * ����������Ϣ
     *
     * */
    Comment save(Comment comment);
    /*
     * ����idɾ������
     *
     * */
    void delete(Long id);
    /*
     * ����id����ĳ������
     *
     * */
    Comment findById(Long id);

}
