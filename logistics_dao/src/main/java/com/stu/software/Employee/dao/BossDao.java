package com.stu.software.Employee.dao;

import com.stu.software.Employee.domain.Boss;
import com.stu.software.dao.GenericTreeDao;
import org.springframework.stereotype.Repository;

@Repository("bossDao")
public interface BossDao extends GenericTreeDao<Boss,Long> {
}
