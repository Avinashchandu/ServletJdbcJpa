package com.jsp.Dao;

import java.util.List;

import com.jsp.model.Employee;

public interface EmployeeDao {

	List<Employee> getDetails();
	List<Employee> getDetails(int deptno);
	Employee getDetailsById(int id);
	int update(Employee emp);
	int delete(int id);
	int Insert(int employeeId, String empName, double empSalary, int deptNo);
	
}
