package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementScanner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter details");
		System.out.println("user_id,user_name,user_email,user_password,user_mobile_number,user_address,user_gender,Dob");
		int id = sc.nextInt();
		String name = sc.next();
		String email = sc.next();
		String password = sc.next();
		long phone = sc.nextLong();
		String address = sc.next();
		String gender = sc.next();
		String dob = sc.next();
		 String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		 String insert = "insert into chandu.user_information values(?,?,?,?,?,?,?,?)";
		 try {
			Connection c = DriverManager.getConnection(url);
			System.out.println("Connected");
			PreparedStatement p = c.prepareStatement(insert);
			p.setInt(1, id);
			p.setString(2, name);
			p.setString(3, email);
			p.setString(4, password);
			p.setLong(5, phone);
			p.setString(6, address);
			p.setString(7, gender);
			p.setString(8, dob);
			System.out.println(p.executeUpdate());
	}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
}}
