package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Selection {

	public static void main(String[] args) {
		 String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		 String s1 = "Select * from chandu.student";
	     try {
			Connection c = DriverManager.getConnection(url);
			Statement s = c.createStatement();
			ResultSet r =s.executeQuery(s1);
			if(r.isBeforeFirst())
			{
			while(r.next())
			{
				if(r.getInt("student_percentage")<=35)
				{
					System.out.println(r.getString(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5)+" ");
				}
			}
			}
			else
			{
				System.out.println("no data");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
     
}
