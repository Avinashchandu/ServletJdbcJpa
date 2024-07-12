package com.jsp.Dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.jsp.model.Employee;

public class EmployeeDaoimpl implements EmployeeDao {

	int i;
	 String url ="jdbc:mysql://localhost:3306?user=root&password=12345";
	 List<Employee> list = new ArrayList<Employee>();
	@Override
	 public List<Employee> getDetails() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
		    Statement s = connection.createStatement();
		    ResultSet op = s.executeQuery("select * from chandu.employee");
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
	 @Override
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
	@Override
	public Employee getDetailsById(int id) {
		String get = "select * from chandu.employee where emp_id = ?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(get);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				Employee emp = new Employee();
				emp.setEmployeeId(rs.getInt(1));
				emp.setEmpName(rs.getString(2));
				emp.setEmpSalary(rs.getInt(3));
				emp.setDeptNo(rs.getInt(4));
				return emp;
				
			}
			else
			{
				return null;
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int update(Employee emp) {
		String update ="Update chandu.Employee set emp_name=?,emp_sal=?,emp_deptno=? where emp_id=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(update);
			ps.setString(1, emp.getEmpName());
			ps.setDouble(2, emp.getEmpSalary());
			ps.setInt(3, emp.getDeptNo());
			ps.setInt(4, emp.getEmployeeId());
			int res = ps.executeUpdate();
			return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
		
	}
	@Override
	public int delete(int id) {
		
		String delete = "delete from chandu.employee where emp_id = ?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			FileInputStream file = new FileInputStream("C:\\Users\\avina\\OneDrive\\Documents\\advanced_java\\EmployeeManagement\\src\\main\\java\\com\\jsp\\file\\application.properties");
			Properties p = new  Properties();
			p.load(file);
			String url = p.getProperty("url");
			String username = p.getProperty("username");
			String password = p.getProperty("password");
			Connection connection = DriverManager.getConnection(url,username,password);
			PreparedStatement ps = connection.prepareStatement(delete);
		    ps.setInt(1, id);
		     i = ps.executeUpdate();
		    System.out.println(i);
		    } catch (Exception e) {
			e.printStackTrace();
		}
		 return i;

		
	}
	@Override
	public 	int Insert(int employeeId, String empName, double empSalary, int deptNo)
	{
		String insert = "insert into chandu.employee(emp_id,emp_name,emp_sal,emp_deptno) values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
		    PreparedStatement ps = connection.prepareStatement(insert);
		    ps.setInt(1, employeeId);
		    ps.setString(2, empName);
		    ps.setDouble(3, empSalary);
		    ps.setInt(4, deptNo);
		    int res = ps.executeUpdate();
		   return res;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return 0;	
	}
	public static void dailyPlanner(String time, String value) {
		 String url ="jdbc:mysql://localhost:3306?user=root&password=12345";
		String select = "select * from chandu.fullday where i = ?";
		Date date = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
	    String str = formatter.format(date);
		try {
		     Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url);
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, str);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				String insert = "update chandu.fullday set ? = ? where i =?";
				PreparedStatement ps1 = connection.prepareStatement(insert);
				ps1.setString(1, time);
				ps1.setString(2, value);
				ps1.setString(3, str);
				ResultSet rs1 = ps1.executeQuery();
			}
			else
			{
				String insert1 = "insert into chandu.fullday where i = ?";
				PreparedStatement ps1 = connection.prepareStatement(insert1);
				ps1.setString(1, str);
				ps1.executeUpdate();
				String insert = "update chandu.fullday set ? = ? where i =?";
				PreparedStatement ps2 = connection.prepareStatement(insert);
				ps2.setString(1, time);
				ps2.setString(2, value);
				ps2.setString(3, str);
				ResultSet rs1 = ps2.executeQuery();

			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		dailyPlanner("mksmk","kkmkmmk");
	}

}
