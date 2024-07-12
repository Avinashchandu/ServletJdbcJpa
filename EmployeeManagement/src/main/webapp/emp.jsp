<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.jsp.model.Employee" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<form action="Bysal">
<input type="number" placeholder="Search By salary or department no"  name = "b"><br><input type="submit">
</form>
<form action ="Reg.html">
<input type="submit" value = "registration">
</form>

<table border="10px">
<%
List<Employee> list= (List<Employee>) session.getAttribute("l");
for(Employee emp : list)
{
%>
      <tr>
      <td><%=emp.getEmployeeId()%></td>
      <td><%=emp.getEmpName()%></td>
      <td><%=emp.getDeptNo()%></td>
      <td><%=emp.getEmpSalary()%></td>
      <td>
      <form action="update" method="post">
      <input value=<%=emp.getEmployeeId()%>  name="empid" hidden="true">
      <input  value="update" type = "submit">
      </form>
      <form action="delete">
      <input value=<%=emp.getEmployeeId()%> hidden="true" name="id">
      <input " type="submit" value="delete">
      </form>
      </td>
      </tr><br>
         
<%	
}
%>

</table>
</center>
</body>
</html>