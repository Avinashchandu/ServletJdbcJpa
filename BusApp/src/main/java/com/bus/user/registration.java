package com.bus.user;

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
@WebServlet("/reg")
public class registration extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String insert = "insert into chandu.busappuser(id,name,email,mobile,password,address)values(?,?,?,?,?)";
		
			try {
				 Class.forName("com.mysql.cj.jdbc.Driver");
				Connection c = DriverManager.getConnection(url);
				PreparedStatement p = c.prepareStatement(insert);
				p.setString(1,name );
				p.setString(2,email );
				p.setString(3,password );
				p.setString(4, mobile);
				p.setString(5, address);
				int res =	p.executeUpdate();
				PrintWriter ps1 = response.getWriter();
			    response.setContentType(insert);
				if(res==1)
				{
					ps1.println("<center>Sucessful</center>");
				}
				else
				{
					ps1.println("<center>Fail</center>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
