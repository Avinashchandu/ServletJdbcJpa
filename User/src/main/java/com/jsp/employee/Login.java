package com.jsp.employee;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		int rows =Integer.parseInt(req.getParameter("a"));;
		int space = rows-1;
		int n = 2*rows-1;
		int star = 1;
		for (int i = 0;i<n ;i++ )
		{
			for (int j = 0;j<space ;j++ )
			{
				System.out.print(" ");
			}
			for (int j = 1;j<=star ;j++ )
			{
				if(j==1||j==star)
				
				{
					System.out.print(" *");
				}
				else
					System.out.print("  ");

				
			}
			if(i<n/2)
			{
				space--;
				star++;
				
			}
			else
			{
				space++;
				star--;
			}
		System.out.println("");
		}
		
	}

}
