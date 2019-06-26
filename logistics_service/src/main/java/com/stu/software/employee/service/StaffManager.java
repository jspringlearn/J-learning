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
    Staff save(Staff staff);//保存员工信息
    void delete(Long id);//根据员工id删除员工
    Staff findById(Long id);//根据员工id找到员工
    List<Staff> getAll();//所有员工信息
    void upd(Staff staff);//通过员工实体更新员工信息
    String getlocation (Long id);//根据id得到员工的地点
    String getmsg (String orderid);//根据订单编号得到配送位置
}
