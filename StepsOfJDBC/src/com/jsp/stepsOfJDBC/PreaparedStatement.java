package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreaparedStatement {
public static void main(String[] args) {
	
	 String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	 String insert = "insert into chandu.user_information(user_id,user_name,user_email,user_password,user_mobile_number,user_address,user_gender)values(?,?,?,?,?,?,?)";
	 try {
		Connection c = DriverManager.getConnection(url);
		System.out.println("Connected");
		PreparedStatement p = c.prepareStatement(insert);
		p.setString(1, "104");
		p.setString(2, "rani");
		p.setString(3, "rani@gmail.com");
		p.setString(4, "14268");
		p.setString(5, "51212");
		p.setString(6, "kbhb");
		p.setString(7, "female");
		p.executeUpdate();
		System.out.println("Inserted");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
