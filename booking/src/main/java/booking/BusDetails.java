package booking;

 import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class bus
{
	private int busid;
	private String booking_from;
	private String boooking_to;
	private String time;
	private int cost;
	
	
	public bus(int busid, String booking_from, String boooking_to, String time, int cost) {
	
		this.busid = busid;
		this.booking_from = booking_from;
		this.boooking_to = boooking_to;
		this.time = time;
		this.cost = cost;
	}


	public bus() {
		
	}


	public int getBusid() {
		return busid;
	}


	public void setBusid(int busid) {
		this.busid = busid;
	}


	public String getBooking_from() {
		return booking_from;
	}


	public void setBooking_from(String booking_from) {
		this.booking_from = booking_from;
	}


	public String getBoooking_to() {
		return boooking_to;
	}


	public void setBoooking_to(String boooking_to) {
		this.boooking_to = boooking_to;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return " busid=" + busid + "\n booking_from=" + booking_from + "\n boooking_to=" + boooking_to + "\n time="
				+ time + "\n cost=" + cost+"\n\n\n" ;
	}
	
}
@WebServlet("/buss")
public class BusDetails extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  List<bus> l = new ArrayList<bus>();
	  String fro = request.getParameter("from");
	  String to = request.getParameter("to");
	  String select = "Select * from  chandu.busdetails where fro = ? and dest = ?;";
	  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection =	DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=12345");
			PreparedStatement ps = connection.prepareStatement(select);
			ps.setString(1, fro);
			ps.setString(2, to);
			ResultSet rs =ps.executeQuery();
			PrintWriter ps1 = response.getWriter();
			while(rs.next())
			{
				bus b = new bus();
				b.setBooking_from(rs.getString("fro"));
				b.setBusid(rs.getInt("id"));
				b.setBoooking_to(rs.getString("dest"));
				b.setTime(rs.getString("time"));
				b.setCost(rs.getInt("price"));
				l.add(b);
				
			}
			int count  = 0;
			for(bus b :l)
			{
				System.out.println(" "
						+ "Bus NO : "+ ++count);
				System.out.println(b);
			}
			System.out.println("Enter the bus no you want to choose");
			Scanner sc = new Scanner(System.in);
			bus b = l.get(sc.nextInt()-1);
			System.out.println(" bus Selected :: ");
			System.out.println(b);
			
			String insert = "insert into chandu.busbook(id,fro,dest,time,price) values(?,?,?,?,?) ";
			PreparedStatement ps2 = connection.prepareStatement(insert);
			ps2.setInt(1, b.getBusid());
			ps2.setString(2, b.getBooking_from());
			ps2.setString(3, b.getBoooking_to());
			ps2.setString(4, b.getTime());
			ps2.setInt(5, b.getCost());
			ps2.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
