package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/this")
public class Registration extends GenericServlet{

	
	
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("DOB");
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		 String insert = "insert into chandu.user_information(user_id,user_name,user_email,user_password,user_mobile_number,user_address,user_gender)values(?,?,?,?,?,?,?)";
		 try {
			Connection c = DriverManager.getConnection(url);
			System.out.println("Connected");
			PreparedStatement p = c.prepareStatement(insert);
			p.setString(1,name );
			p.setString(2,email );
			p.setString(3,password );
			p.setString(4, mobile);
			p.setString(5, address);
			p.setString(6, gender);
			p.setString(7, DOB);
		int res =	p.executeUpdate();
		PrintWriter ps1 = response.getWriter();
		if(res==1)
		{
			ps1.println("<center>Sucessful</center>");
		}
		else
		{
			ps1.println("<center>Fail</center>");
		}
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	

}
