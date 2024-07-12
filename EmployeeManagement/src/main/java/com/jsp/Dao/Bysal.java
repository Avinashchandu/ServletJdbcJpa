package com.jsp.Dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jsp.model.Employee;

public class Bysal  {

	 String url ="jdbc:mysql://localhost:3306/advanced_java_projects?user=root&password=12345";
	 List<Employee> list = new ArrayList<Employee>();
	
	 public List<Employee> getDetails(int deptno) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
		    PreparedStatement s = connection.prepareStatement("select * from chandu.employee where emp_sal = ? or emp_deptno = ? ");
		    s.setInt(1, deptno);
		    s.setInt(2, deptno);
		    ResultSet op = s.executeQuery();
		    if(op.isBeforeFirst())
		    {
		    while(op.next())
		    {
		    	Employee emp = new Employee();
		    	emp.setEmployeeId(op.getInt(1));
		    	emp.setEmpName(op.getString(2));
		    	emp.setEmpSalary(op.getDouble(3));
		    	emp.setDeptNo(op.getInt(4));
		    	list.add(emp);
		    }
		    }
		    else
		    {
		    	System.out.println("No details Found");
		    }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
		
	}

}
