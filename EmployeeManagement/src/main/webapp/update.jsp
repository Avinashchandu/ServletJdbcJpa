<%@page import="com.jsp.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Employee emp = (Employee)session.getAttribute("Empdetails");

%>>
<center>
<form action = "Updating">
<input value=<%=emp.getEmployeeId() %> hidden="true" name ="empid">
Emp Name :<input value=<%=emp.getEmpName() %> name="name"><br>
Emp sal  :<input value=<%=emp.getEmpSalary() %> name="sal"><br>
Emp Dept :<input value=<%=emp.getDeptNo() %> name="dept"><br> 
<input type="submit">
</form>
</center>
</body>
</html>