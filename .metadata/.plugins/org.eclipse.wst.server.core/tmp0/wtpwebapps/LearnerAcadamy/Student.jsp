<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*,com.simplilearn.model.*,com.simplilearn.repository.*"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Info about student</title>
</head>
<body>
<form  method="post" action="sudentHandler">
<%

%>
<table>
<tr>
<td>First Name:</td><td> <input type="text" name="fname" ></td>
</tr>
<tr>
<td>Last Name: </td><td><input type="text" name="lname" ></td>
</tr>
<tr>
<td></td><td>

<input type="submit" value="Save">

</td>
</tr>
</table>
</form>

</body>
</html>