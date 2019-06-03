package com.stu.software.admin.service;

import com.stu.software.admin.domain.User;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserManager extends GenericManager<User, Long> {

    List<User> findAll();

    User findbyUsername(String username);
}
