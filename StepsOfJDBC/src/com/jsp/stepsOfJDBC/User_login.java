package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class User_login {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Email");
		String em = sc.next();
		System.out.println("Enter Your password");
		String pw = sc.next();
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String select = "select * from chandu.user_information where user_email=? and user_password=?";
         try {
			Connection c = DriverManager.getConnection(url);
			PreparedStatement p = c.prepareStatement(select);
			p.setString(1, em);
			p.setString(2, pw);
			ResultSet r = p.executeQuery();
			if(r.next())
			{
				//System.out.println("Logged in");
				Random rd = new Random();
				int otp = 0;
				while(otp<999)
				{
				otp = rd.nextInt(10000);
				}
				otp = rd.nextInt(10000);
				if(otp<=1000)
					otp=otp+1000;
				System.out.println("OTP genertated "+otp);
				System.out.println("Enter Your OTP");
				int otp1 = sc.nextInt();
				if(otp==otp1)
					System.out.println("Logged in............");
				else
					System.out.println("Invalid OTP");
			}
			else
				System.out.println("invalid details");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
