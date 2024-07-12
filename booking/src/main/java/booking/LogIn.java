package booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mysql.cj.jdbc.Driver;


@WebServlet("/loin")
public class LogIn extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =  request.getParameter("username");
		String password = request.getParameter("password");
		String select ="select * from chandu.busappuser where email =? and password =?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection =	DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
		PreparedStatement ps = connection.prepareStatement(select);
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs =ps.executeQuery();
		PrintWriter ps1 = response.getWriter();
		if(rs.next())
		{
			RequestDispatcher r1 = request.getRequestDispatcher("book.html");
			r1.forward(request, response);
		}
		else
		{
			RequestDispatcher r1 = request.getRequestDispatcher("Login.html");
			r1.include(request, response);
			ps1.println("Invalid");
		}
		System.out.println(rs.next());
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	 

}
