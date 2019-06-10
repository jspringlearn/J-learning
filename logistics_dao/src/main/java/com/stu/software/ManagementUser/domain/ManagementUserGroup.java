package com.stu.software.ManagementUser.domain;

import com.stu.software.domain.BaseTreeEntity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_ADMIN_ManagementUser")
@NamedQueries({ @NamedQuery(name = "ManagementUserGroup.getRoot", query="select s from ManagementUserGroup s where s.parent is null") })

public class ManagementUserGroup extends BaseTreeEntity<ManagementUserGroup> {



    private static final long serialVersionUID = -1747387466611154608L;

    /**
     * Management 管理员
     *
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

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER, mappedBy = "managementUserGroup")
    Set<ManagementUser> managementUsers;

    public void setManagementUsers(Set<ManagementUser> managementUsers) {
        this.managementUsers = managementUsers;
    }

    public Set<ManagementUser> getManagementUsers() {
        return managementUsers;
    }

    public void setManagementID(String managementID) {
        ManagementID = managementID;
    }

    public void setManagementName(String managementName) {
        ManagementName = managementName;
    }

    public void setCommonManagementID(String commonManagementID) {
        CommonManagementID = commonManagementID;
    }

    public void setCommonManagementName(String commonManagementName) {
        CommonManagementName = commonManagementName;
    }

    public String getManagementID() {
        return ManagementID;
    }

    public String getManagementName() {
        return ManagementName;
    }

    public String getCommonManagementID() {
        return CommonManagementID;
    }

    public String getCommonManagementName() {
        return CommonManagementName;
    }

    @Override
    public String toString() {
        return "Group [ManagementID=" + ManagementID + ", ManagementName=" + ManagementName + ", " +
                " CommonManagementID=\" + CommonManagementID + \",CommonManagementName=\" + CommonManagementName + \",]";
    }
}
