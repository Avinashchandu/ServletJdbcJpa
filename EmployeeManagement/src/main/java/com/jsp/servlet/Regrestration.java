package com.jsp.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmployeeDaoimpl;
@WebServlet("/reg")
public class Regrestration extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Double sal = Double.parseDouble(request.getParameter("sal"));
		int deptno =  Integer.parseInt(request.getParameter("deptno"));
		EmployeeDao emp = new EmployeeDaoimpl();
		int res = emp.Insert(id, name, sal, deptno);
		if (res!=0)
		{
			RequestDispatcher rs = request.getRequestDispatcher("/all");
			rs.forward(request, response);
		} 
		else {
			RequestDispatcher rs = request.getRequestDispatcher("Reg.jsp");
			rs.forward(request, response);
			

		}
	}
}
