package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Passwordupdate {
  public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	  String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	  String update ="update chandu.user_information set user_password  =? where user_email =?";
	  try {
		Connection c = DriverManager.getConnection(url);
		
		System.out.println("Enter your Email");
		String em = sc.next();
		System.out.println("Enter new password");
		String pw = sc.next();
		System.out.println("confirm password");
		String cpw = sc.next();
		if(pw.equals(cpw))
		{
			PreparedStatement p = c.prepareStatement(update);
			p.setString(1, pw);
			p.setString(2, em);
			int r = p.executeUpdate();
			if(r>0)
			{
				System.out.println("PassWord Updated");
			}
			else
			{
				System.out.println("Email is invalid");
			}
			}
		else
			System.out.println("Confirm Password Did Not Match");
		}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}     
}
