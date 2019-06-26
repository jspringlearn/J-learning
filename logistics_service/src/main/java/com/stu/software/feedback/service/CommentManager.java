package com.stu.software.feedback.service;

import com.stu.software.feedback.domain.Comment;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public interface CommentManager extends GenericManager<Comment, Long> {
    /**
     * fetch all entities
     *
     * @return list for all entities
     */
    List<Comment> findAll();


    /**
     * save specified entity;
     *
     * @param entity
     *            entity for saving
     * @return saved domain entity
     */
    Comment save(Comment comment);




    
    /**
     * * delete entity according given id
     *
     * @param id
     */
    void delete(Long id);




    /**
     * fetch specified entity according id;
     *
     * @param id
     *            entity id;
     * @return entity
     */
    Comment findById(Long id);

}

