package booking;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Book")
public class Booking extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s1 = request.getSession();
		String email =(String) s1.getAttribute("email");
		System.out.println("n"+email);
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String date = request.getParameter("date");
		String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
		String insert = "insert into chandu.busdata(email,dep,des,date)values(?,?,?,?)";
		Random r = new Random();
		int id = r.nextInt();
		if(id<1000)
		{
			id = id+1000;
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection(url);
			PreparedStatement p = c.prepareStatement(insert);
			p.setString(1,email);
			p.setString(2,to );
			p.setString(3,from );
			p.setString(4, date);
			int res =	p.executeUpdate();
			PrintWriter ps1 = response.getWriter();
			response.setContentType("text/html");
			
			if(res==1)
			{
				RequestDispatcher r1 = request.getRequestDispatcher("book.html");
				ps1.println("<div>\r\n"
						+ "    <center>\r\n"
						+ "        <h1>destination</h1>"+to+"\r\n"
						+ "        <br>\r\n"
						+ "        <h1>departure</h1>"+from+"\r\n"
						+ "        <br>\r\n"
						+ "        <h1>Date</h1>"+date+"\r\n"
						+ "        <br>\r\n"
						+ "    </center>\r\n"
						+ "</div>");
				r1.include(request, response);
				ps1.println("<center>Successful</center>");
			}
			else
			{
				RequestDispatcher r1 = request.getRequestDispatcher("book.html");
				r1.include(request, response);
				ps1.println("Invalid");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("hhhbv");
	}

}
