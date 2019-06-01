package com.stu.software.feedback.service.impl;

import javax.transaction.Transactional;

import com.stu.software.feedback.dao.CtypeDao;
import com.stu.software.feedback.domain.Ctype;
import com.stu.software.feedback.service.CtypeManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stu.software.service.impl.GenericTreeManagerImpl;


@Component
@Transactional
public class CtypeManagerImpl extends GenericTreeManagerImpl<Ctype, Long> implements CtypeManager {



    CtypeDao ctypeDao;


    @Autowired
    public void setCtypeDao(CtypeDao ctypeDao) {
        this.ctypeDao = ctypeDao;
        this.treeDao=this.ctypeDao;
        this.dao=this.treeDao;

    }
}