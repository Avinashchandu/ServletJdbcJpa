package com.jsp.employee;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Update extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int n = 1947;
		if(n%2==0)
		{
		System.out.println("Even");	
		}
		else
		{
			System.out.println("odd");
		}
		
	}

}
