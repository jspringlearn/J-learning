package com.stu.software.customer.service.impl;

import com.stu.software.customer.dao.CustomerDao;
import com.stu.software.customer.domain.Customer;
import com.stu.software.customer.service.CustomerManage;
import com.stu.software.service.impl.GenericManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class CustomerManagerImpl extends GenericManagerImpl<Customer, Long> implements CustomerManage {

    CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {

        this.customerDao = customerDao;
        this.dao = this.customerDao;
    }

    @Override
    public List<Customer> findByManagementUserName(String ManagementName) {
        return null;
    }

    @Override
    public void savemanagementUser(String name, String phone) {
        Customer customer = new Customer();
        customer.setMName(name);
        customer.setMPhone(phone);
        this.customerDao.save(customer);
    }


    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public List<Customer> findBySno(int sno) {
        Customer queryObject = new Customer();
        queryObject.setDateCreated(null);
        queryObject.setDateModified(null);
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase(true).withMatcher("sno", ExampleMatcher.GenericPropertyMatchers.startsWith());
        Example<Customer> example = Example.of(queryObject, exampleMatcher);
        List<Customer> result = this.dao.findAll(example);
        return result;
    }


    @Override
    public Boolean deleteById(Long id) {
        Optional<Customer> managementUser = this.dao.findById(id);
        /**
         * Problem:
         * Judge is null
         * return false
         */
        if (managementUser.equals(null)) {
            return false;
        } else {
            this.dao.delete(managementUser.get());
            return true;
        }
    }

    @Override
    public Boolean deleteBySno(int sno) {
        List<Customer> studentList = this.findBySno(sno);
        if (studentList.size() == 0) {
            return false;
        } else {
            for (int i = 0; i < studentList.size(); i++) {
                this.dao.delete(studentList.get(i));
            }
            return true;
        }
    }


}
