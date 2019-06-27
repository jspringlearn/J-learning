package com.stu.software.customer.service;

import com.stu.software.customer.domain.Customer;
import com.stu.software.service.GenericManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerManage extends GenericManager<Customer, Long> {
    /*
     *
     * 根据姓名查找管理员
     * */
    List<Customer> findByManagementUserName(String ManagementName);

    void savemanagementUser(String name, String phone);

    List<Customer> getAll();

    List<Customer> findBySno(int sno);


    Boolean deleteById(Long id);

    Boolean deleteBySno(int sno);

}
