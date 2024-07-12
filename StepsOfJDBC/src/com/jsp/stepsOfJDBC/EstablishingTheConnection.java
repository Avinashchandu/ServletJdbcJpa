package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EstablishingTheConnection {
public static void main(String[] args) {
	String url = "jdbc:mysql://localhost:3306/advanced_java_projects?user=root&password=12345";
	try {
		Connection c = DriverManager.getConnection(url);
		System.out.println("Connection Esatblished");
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
