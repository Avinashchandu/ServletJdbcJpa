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

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmployeeDaoimpl;
import com.jsp.model.Employee;
@WebServlet("/all")
public class AllEmployeeDetails extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDao emp = new EmployeeDaoimpl();
		List<Employee> list = emp.getDetails();
		HttpSession Hs = request.getSession();
		Hs.setAttribute("l", list);
		RequestDispatcher rs = request.getRequestDispatcher("emp.jsp");
		rs.forward(request, response);
		
	}

}
