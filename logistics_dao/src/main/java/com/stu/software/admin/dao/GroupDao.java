package com.stu.software.admin.dao;

import com.stu.software.dao.*;
import com.stu.software.admin.domain.Group;
import org.springframework.stereotype.Repository;

@Repository("groupDao")
public interface GroupDao extends GenericTreeDao<Group, Long> {

}
