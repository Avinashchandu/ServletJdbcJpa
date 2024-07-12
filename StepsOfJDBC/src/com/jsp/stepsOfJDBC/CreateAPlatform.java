package com.jsp.stepsOfJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateAPlatform {
 public static void main(String[] args) {
	 String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
	// String insert ="insert into chandu.student values(117,'varun','varun@gmail.com','42155',70)";
	 String update ="update chandu.student set student_percentage =20 where student_id =101";
	 String delete = "delete from chandu.employee where emp_name like 's%'";
	 String delete1 = "delete from chandu.student where Student_percentage <35";
		try {
			Connection c = DriverManager.getConnection(url);
			System.out.println("Connection Esatblished");
			Statement s = c.createStatement();
			System.out.println("Platform is created");
		    //int res = s.executeUpdate(insert);
			int res1 = s.executeUpdate(update);
			int res2 = s.executeUpdate(delete);
			int res3 = s.executeUpdate(delete1);
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}
}
