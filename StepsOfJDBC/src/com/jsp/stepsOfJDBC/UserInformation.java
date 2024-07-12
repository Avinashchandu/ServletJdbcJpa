package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserInformation {
	public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	//String insert = "insert into  chandu.user_information values(103,'varun','varun@gmail.com','12423',12394546,'Bihar','male')";
	String delete ="delete from chandu.user_information where user_address like'jntu%'";
    String update ="update chandu.user_information set user_password  ='20' where user_email ='avinash@gmail.com'";
	String s1 = "select * from chandu.user_information";
    try {
		Connection c = DriverManager.getConnection(url);
		System.out.println("Connection Esatblished");
		Statement s = c.createStatement();
		System.out.println("Platform is created");
		//System.out.println(s.executeUpdate(insert));
		System.out.println(s.executeUpdate(delete));
		System.out.println(s.executeUpdate(update));
		ResultSet r =s.executeQuery(s1);
		if(r.isBeforeFirst())
		{
		while(r.next())
		{
			
		System.out.println("Email "+r.getString(3)+" Password "+r.getString(4));
			
		}
		}
		else
		{
			System.out.println("no data");
		}

		
	   
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
}
