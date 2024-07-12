package booking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login")
public class login1 extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		String select  = "Select * from busappuser  where email = ? and password = ?";
		 try {
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chandu?user=root&password=12345");
				PreparedStatement ps = connection.prepareStatement(select);
				ps.setString(1, email);
				ps.setString(2, password);
				ResultSet r = ps.executeQuery();
				PrintWriter p = response.getWriter();
				HttpSession s = request.getSession();
				if(r.next())
				{
					RequestDispatcher r1 = request.getRequestDispatcher("/book.html");
					s.setAttribute("email",email );
					r1.include(request, response);
				}
				else
				{
					p.println("Invalid");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
	
	

}
