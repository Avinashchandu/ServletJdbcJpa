package com.jsp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.Dao.Bysal;
import com.jsp.Dao.EmployeeDaoimpl;
import com.jsp.model.Employee;
@WebServlet("/Bysal")
public class BySal extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n = Integer.parseInt(request.getParameter("b"));
		EmployeeDaoimpl emp = new EmployeeDaoimpl();
		List<Employee> list = emp.getDetails(n);
		if(list.isEmpty())
		{
			RequestDispatcher rs = request.getRequestDispatcher("NoData.html");
			rs.forward(request, response);
		}
		else
		{
		HttpSession Hs = request.getSession();
		Hs.setAttribute("l", list);
		RequestDispatcher rs = request.getRequestDispatcher("emp.jsp");
		rs.forward(request, response);
		}
		
	}

}
