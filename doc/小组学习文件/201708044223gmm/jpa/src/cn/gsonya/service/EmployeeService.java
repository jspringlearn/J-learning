package cn.gsonya.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import cn.gsonya.entity.Employee;

public class EmployeeService {
	protected EntityManager entityManager;
	public EmployeeService(EntityManager entityManager) {
		this.entityManager=entityManager;
	}
	
	//创建Employee
	public Employee createEmployee(int id,String name,long salary) {
		Employee employee=new Employee(id);
		employee.setName(name);
		employee.setSalary(salary);
		entityManager.persist(employee);
		return employee;
	}
	//删除
	public void removeEmployee(int id) {
		Employee employee=findEmployee(id);
		if(employee!=null) {
			entityManager.remove(employee);
		}
	}
	//查找
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}
	//更新
	public Employee raiseEmployeeSalary(int id,long raise) {
		Employee employee =entityManager.find(Employee.class, id);
		if(employee!=null) {
			employee.setSalary(employee.getSalary()+raise);
		}
		return employee;
	}
	//查询所有
	public List<Employee>findAllEmployees(){
		TypedQuery<Employee>query=entityManager.createQuery("select e from employee",Employee.class);
		return query.getResultList();
	}

}
