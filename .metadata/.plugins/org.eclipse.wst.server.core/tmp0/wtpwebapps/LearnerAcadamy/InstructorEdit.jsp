<%@page import="com.simplilearn.repository.InstructorRepository"%>
<%@page import="com.simplilearn.model.Instructor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="instructorEditerHandler">
<%
String command = request.getParameter("command");
Instructor instructor=new Instructor();
if(command!=null){
	String id = request.getParameter("id");
	InstructorRepository instructorReposetory = new InstructorRepository();
	instructor=instructorReposetory.getById(Integer.parseInt(id));
}
%>
<table>
<tr>
<td>First Name:</td><td> <input type="text" name="fname" value=<%=instructor.getFname() %>></td>
</tr>
<tr>
<td>Last Name:</td><td> <input type="text" name="lname" value=<%=instructor.getLname() %>></td>
</tr>
<tr>


<td>
<%
if(command!=null && "edit".equalsIgnoreCase(command)) {
%>
<input type="submit" value="Edit">
<%
} else if(command!=null && "delete".equalsIgnoreCase(command)) {
%>
<input type="submit" value="Delete">
<% 
}else{
%>
<input type="submit" value="Save">
<%}%>
</td>
</tr>
</table>
</form>

</body>
</html>