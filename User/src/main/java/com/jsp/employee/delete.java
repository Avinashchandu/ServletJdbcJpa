package com.jsp.employee;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class delete extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int rows =Integer.parseInt(req.getParameter("a"));
		for(int i = 0;i<rows;i++)
		{
			for(int j =0;j<rows;j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
