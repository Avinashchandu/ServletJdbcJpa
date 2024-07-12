package com.jsp.model;

public class Employee {
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", empSalary=" + empSalary + ", deptNo="
				+ deptNo + "]";
	}
	private int employeeId;
	private String empName;
	private double empSalary;
    private int deptNo;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public Employee(int employeeId, String empName, double empSalary, int deptNo) {
		
		this.employeeId = employeeId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.deptNo = deptNo;
	}
	public Employee() {
		
	}
    

}
