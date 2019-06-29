package com.stu.software.customer.domain;

import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_CustomerGroup")
@NamedQueries({@NamedQuery(name = "CustomerGroup.getRoot", query = "select s from CustomerGroup s where s.parent is null")})

public class CustomerGroup extends BaseTreeEntity<CustomerGroup> {


    private static final long serialVersionUID = -1747387466611154608L;

    /**
     * Management 管理员
     * <p>
     * CommonManagement 普通管理员
     */
    @Column(name = "ManagementID")
    String ManagementID;

    @Column(name = "ManagementName")
    String ManagementName;

    @Column(name = "CommonManagementID")
    String CommonManagementID;

    @Column(name = "CommonManagementName")
    String CommonManagementName;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "customerGroup")
    Set<Customer> customers;

    public String getManagementID() {
        return ManagementID;
    }

    public void setManagementID(String managementID) {
        ManagementID = managementID;
    }

    public String getManagementName() {
        return ManagementName;
    }

    public void setManagementName(String managementName) {
        ManagementName = managementName;
    }

    public String getCommonManagementID() {
        return CommonManagementID;
    }

    public void setCommonManagementID(String commonManagementID) {
        CommonManagementID = commonManagementID;
    }

    public String getCommonManagementName() {
        return CommonManagementName;
    }

    public void setCommonManagementName(String commonManagementName) {
        CommonManagementName = commonManagementName;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
