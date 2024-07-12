package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Delete extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter p = res.getWriter();
		int array[] = {1,2,2,6,9,65,45,7,6,7,1,0,45,9};
		HashSet a = new HashSet();
		for(int i =0;i<array.length;i++)
		{
			a.add(array[i]);
		}
		p.println(a);
		
	}

	

}
