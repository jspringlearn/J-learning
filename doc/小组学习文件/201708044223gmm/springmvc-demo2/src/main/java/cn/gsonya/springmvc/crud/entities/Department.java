package cn.gsonya.springmvc.crud.entities;

import java.util.Set;

/**
 * @author gsonya
 * @title
 * @Package cn.gsonya.springmvc.crud.entities
 * @date 2019/6/9 18:34
 */
public class Department {
    private Integer id;
    private String departmentName;
    private Set<Employee> employee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Department() {
    }
}
