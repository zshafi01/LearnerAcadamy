<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" 
    import="com.simplilearn.model.*, java.util.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<div class="container">


<div>
<% 
User user = (User)session.getAttribute("userinfo");

if(user!=null && "admin".equals(user.getType())) {
	
	%>
<a href="Course.jsp">Manage Course</a>
<a href="Class.jsp">Manage Class</a>
<a href="Student.jsp">Manage Student</a>
<a href="Instructor.jsp">Manage Instructor</a>
<%} %>
</div>

<div>
<h2> Welcome to Learners Acadamy!</h2>
<hr>
<%
List<Classes>classesList = (List<Classes>)session.getAttribute("classesList");
if(classesList!=null && !classesList.isEmpty()) {

%>
<table>
<thead>
<tr><th>Year</th><th>Semester</th><th>Instractor</th><th>Course</th></tr>
</thead>
<tbody>
<% for(Classes classes:classesList)
{
	%>
<tr>
	<td><%=classes.getYear() %></td>
	<td><%=classes.getSemester() %></td>
	<td>inst</td>
	<td>crs</td>
</tr>
<%} %>
</tbody>
</table>
<%} %>
</div>

<div>
<%@ include file="footer.jsp" %>
</div>

</div>
</body>
</html>