package com.stu.software.customer.domain;


import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;

@Entity
@Table(name = "T_Customer")
public class Customer extends BaseTreeEntity<Customer> {
    private static final long serialVersionUID = 2956980785739215106L;
    /**
     * Management_Name 管理员姓名
     * <p>
     * <p>
     * Management_MPhone管理员电话
     */
    @Column(name = "Management_MName")
    String MName;
    @Column(name = "Management_MPhone")
    String MPhone;

    @ManyToOne
    @JoinColumn(name = "ManagementUserGroup_ID")
    CustomerGroup customerGroup;

    public String getMName() {
        return MName;
    }

    public void setMName(String MName) {
        this.MName = MName;
    }

    public String getMPhone() {
        return MPhone;
    }

    public void setMPhone(String MPhone) {
        this.MPhone = MPhone;
    }

    public CustomerGroup getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }
}
