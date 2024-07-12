package com.jsp.employee;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Login extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		String s = "race";
		char[] a = s.toCharArray();
		String s1 = "care";
		char b[] = s1.toCharArray();
		if(s.length()!=s1.length())
		{
			System.out.println("Not an anagram");
		}
		else
		{
			for(int i =0;i<a.length;i++)
			{
				for(int j = i+1;j<a.length;j++)
				{
					if(a[i]>a[j])
					{
						char t = a[i];
						a[i]=a[j];
						a[j]=t;
					}
					if(b[i]>b[j])
					{
						char t = b[i];
						b[i]=b[j];
						b[j]=t;
					}
				}
			}
			int count = 0;
			for(int i = 0;i<a.length;i++)
			{
				if(a[i]!=b[i])
					count++;
			}
			if(count>0)
			{
				System.out.println("Not an anagram");
			}
			else {
				System.out.println("Anagram");
			}
		}
		
		
	}
		
	}
	
	


