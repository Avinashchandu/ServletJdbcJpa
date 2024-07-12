package com.jsp.servlet;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import com.jsp.Dao.EmployeeDao;
import com.jsp.Dao.EmployeeDaoimpl;
import com.jsp.model.Employee;
@WebServlet("/Updating")
public class Updating extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("empid"));
		String name = request.getParameter("name");
		String sal1 = request.getParameter("sal");
		int deptno = Integer.parseInt(request.getParameter("dept"));	
		double sal = Double.parseDouble(sal1);
		Employee emp = new Employee();
		emp.setEmpName(name);
		emp.setDeptNo(deptno);
		emp.setEmpSalary(sal);
		emp.setEmployeeId(id);
        
		EmployeeDao dao = new EmployeeDaoimpl();
		int res =dao.update(emp);
		if(res==1)
		{
			RequestDispatcher rs = request.getRequestDispatcher("emp.jsp");
			rs.forward(request, response);
		}
		else
		{
			RequestDispatcher rs = request.getRequestDispatcher("NoData.html");
			rs.forward(request, response);
		}
	}

}
