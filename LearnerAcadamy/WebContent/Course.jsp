<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.simplilearn.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info About Course</title>
</head>
<body>
<form method="post" action="courseHandler">
<table>
<tr>
<td>Course Name:</td><td><input type="text" name="c_name"></td>
</tr>
<tr>
<td>Course hour:</td><td><input type="text" name="c_hour"></td>
</tr>
<tr>
<td>Course Price:</td><td><input type="text" name="c_price"></td>
</tr>
<tr>
<td>Course Description:</td><td><input type="text" name="c_desc"></td>
</tr>
<tr>
<td>Instructor:</td><td><select name="instructor">
    <option value="fname1">Ezedin</option>
    <option value="fname2">Mohammed</option>
	 <option value="fname3">Nebila</option>
</select></td>
</tr>
<tr>
<td>Class:</td><td><select name="class">
    <option value="classA">Class A</option>
    <option value="classB">Class B</option>
	 <option value="classC">Class C</option>
</select>
</td></tr>
<tr>
<td><input type="submit" value="submit"></td>
</tr>
</table>
</form>

</body>
</html>