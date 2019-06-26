package com.stu.software.employee.service;

import com.stu.software.Employee.domain.Staff;
import com.stu.software.service.GenericManager;

import java.util.List;

/**
 * @author 缑曼曼
 * @title
 * @Package com.stu.software.admin.service
 * @date 2019/5/20 15:49
 */
public interface StaffManager extends GenericManager<Staff,Long> {
    String sayHello(String name);
    Staff save(Staff staff);
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
    Staff findById(Long id);
    /**
     * fetch all entities
     *
     * @return list for all entities
     */
    List<Staff> getAll();
    /**
     * update entities
     *
     * @param staff
     */
    void upd(Staff staff);
    /**
     * update entities
     *
     * @param id
     *
     * @return location
     */
    String getlocation (Long id);
    /**
     * update entities
     *
     * @param orderid
     *
     * @return place
     */
    String getmsg (String orderid);
}
