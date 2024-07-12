package com.bus.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Book")
public class Book extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		String email =request.getParameter("c");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String date = request.getParameter("date");
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String insert = "insert into chandu.busdata(email,dep,des,date)values(?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url);
			PreparedStatement p = c.prepareStatement(insert);
			p.setString(1,email );
			p.setString(2,to );
			p.setString(3,from );
			p.setString(4, date);
			int res =	p.executeUpdate();
			PrintWriter ps1 = response.getWriter();
		    response.setContentType(insert);
			if(res==1)
			{
				RequestDispatcher r1 = request.getRequestDispatcher("");
				r1.forward(request, response);
			}
			else
			{
				RequestDispatcher r1 = request.getRequestDispatcher("");
				r1.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
