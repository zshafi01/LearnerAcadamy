<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.simplilearn.model.*,com.simplilearn.repository.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form  method="post" action="sudentEditerHandler">
<%
List<Student> students=(List<Student>)session.getAttribute("instructorList");
String command = request.getParameter("command");
Student student=new Student();

	String id = request.getParameter("id");
	StudentReposetory studentReposetory = new StudentReposetory();
	student=studentReposetory.getById(Integer.parseInt(id));

%>
<table>
<tr>
<td>First Name:</td><td>
<input type="hidden" name="id" value=<%=student.getId()%>>
 <input type="text" name="fname" value=<%=student.getFname() %>></td>
</tr>
<tr>
<td>Last Name: </td><td><input type="text" name="lname" value=<%=student.getLname() %>></td>
</tr>
<tr>
<td></td><td>
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