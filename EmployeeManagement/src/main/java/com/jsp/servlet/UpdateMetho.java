package com.jsp.servlet;

import java.io.IOException;

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
@WebServlet("/update")
public class UpdateMetho extends HttpServlet {
	
   @Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id =Integer.parseInt(request.getParameter("empid"));
	EmployeeDao dao = new EmployeeDaoimpl();
	HttpSession hs = request.getSession();
	Employee emp =  dao.getDetailsById(id);
	if(emp!=null)
	{
		hs.setAttribute("Empdetails", emp);
		System.out.println(emp);
		RequestDispatcher rs = request.getRequestDispatcher("update.jsp");
		rs.forward(request, response);
	}
	else
	{
		RequestDispatcher rs = request.getRequestDispatcher("NoData.html");
		rs.forward(request, response);	
	}
	
}

}
