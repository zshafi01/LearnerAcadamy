<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.simplilearn.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info About Class</title>
</head>
<body>
<form method="post" action="classHandler">

<%
List<Instructor> instructors=(List<Instructor>)session.getAttribute("instructorList"); 
List<Student> students=(List<Student>)session.getAttribute("studentList");
List<Course> courses=(List<Course>)session.getAttribute("courseList");
%>

<table>
<tr>
<td>Class Year:</td><td><input type="text" name="c_year"></td>
</tr>
<tr>
<td>Semester:</td><td><input type="text" name="c_semester"></td>
</tr>
<tr>
<td>Course:</td>
<td>
<select name="course">
<% for(Course course:courses) { %>
    <option value=<%=course.getId() %>><%=course.getTitle() %></option>
	 <%} %>
</select>
</td>
</tr>
<tr>
<td>Instructor:</td><td>


<select name="instructor">
<% for(Instructor instractor:instructors) { %>
    <option value=<%=instractor.getId() %>><%=instractor.getFname() %></option>
	 <%} %>
</select>

</td>
</tr>
<!--  <tr>

</tr>-->
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>

</body>
</html>