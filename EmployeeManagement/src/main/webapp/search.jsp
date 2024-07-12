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
<center>
<form action="search.jsp">
<input type="text" placeholder="Search By salary or department no"  name = "b"><input type="submit">
</form>
<table border="5px">

<body>
<%
int n = Integer.parseInt(request.getParameter("b"));
List<Employee> list= (List<Employee>) session.getAttribute("l");
for(Employee emp : list)
{
	
	if(emp.getEmpSalary()==n||emp.getDeptNo()==n)
	{
%>
      <tr>
      <td><%=emp.getEmployeeId()%></td>
      <td><%=emp.getEmpName()%></td>
      <td><%=emp.getDeptNo()%></td>
      <td><%=emp.getEmpSalary()%></td>
      <td><input value="update" type = "button" ><input " type="button" value="delete">
      </td>
      </tr>
         
<%
	}
	else
		continue;
}
%>

</table>
</center>
</body>
</html>