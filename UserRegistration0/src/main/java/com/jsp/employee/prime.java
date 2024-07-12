package com.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class prime extends GenericServlet{
	
	public static boolean prime(int num)
	{
		int j = 0;
		int count = 0;
		if(num==1 || num==0)
		{
			System.out.println(num+" is Neither Prime Nor Composite");
			return false;
		}
		for(int i = 2;i<(num/2)+1;i++)
		{
			if(num%i==0)
			{
				count++;
				break;
			}
		}
		j++;
		if(count==0)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter p = res.getWriter();
		
		for(int i = 0;i<=100;i++)
		{
			if(prime(i))
				p.println(i+" is Prime \n");
		}
	}
	

}
