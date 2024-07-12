package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmployeeDaoimpl;
@WebServlet("/delete")
public class delete extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
	
	int id = Integer.parseInt(request.getParameter("id"));
	EmployeeDao dao = new EmployeeDaoimpl();
	int i =dao.delete(id);
	if(i!=0)
	{
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
	}
	else
	{
		RequestDispatcher rs = request.getRequestDispatcher("NoData.html");
		rs.forward(request, response);
	}
	}
}
