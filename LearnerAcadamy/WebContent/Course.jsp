<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.simplilearn.model.*,com.simplilearn.repository.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info About Course</title>
</head>
<body>
<form method="post" action="courseHandler">
<!--  -->

<%
List<Instructor> instructors=(List<Instructor>)session.getAttribute("instructorList");
%>
<table>
<tr>
<td>Course Title:</td><td><input type="text" name="c_name" ></td>
</tr>
<tr>
<td>Course hour:</td><td><input type="text" name="c_hour" ></td>
</tr>
<tr>
<td>Course Price:</td><td><input type="text" name="c_price" ></td>
</tr>
<tr>
<td>Course Description:</td><td><textarea name="c_desc" ></textarea></td>
</tr>

<tr>
<td>
<input type="submit" value="Save">

</td>
</tr>
</table>
</form>

</body>
</html>