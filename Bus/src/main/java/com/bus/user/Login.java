package com.bus.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/login")
public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("username");
		String password = req.getParameter("password");
		String select  = "Select * from busappuser  where email = ? and password = ?";
		 try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandu?user=root&password=12345");
				PreparedStatement ps = connection.prepareStatement(select);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet r = ps.executeQuery();
				PrintWriter p = res.getWriter();
				if(r.next())
				{
					RequestDispatcher r1 = req.getRequestDispatcher("/book.html");
					req.setAttribute("email", email);
					r1.include(req, res);
				}
				else
				{
					p.println("Invalid");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
