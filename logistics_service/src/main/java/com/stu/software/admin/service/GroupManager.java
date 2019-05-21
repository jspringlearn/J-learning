package com.stu.software.admin.service;


import com.stu.software.admin.domain.Group;
import com.stu.software.service.GenericTreeManager;
import org.springframework.stereotype.Component;

@Component
public interface GroupManager extends GenericTreeManager<Group, Long> {

}
