<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Learner's Acadamy</title>
</head>
<body>
<form method="post" action="registrationHandler">
<div class="container">


<div>
<%@ include file="header.jsp" %>
</div>

<div>
<table>
<tr>
<td>First Name </td><td><input type="text" name="fname"></td><br/>
</tr>
<tr><td>Last Name</td><td><input type="text" name="lname"></td><br/>
</tr>
<tr><td>Email</td><td><input type="email" name="email"></td><br/>
</tr>
<tr>
<td>Password</td><td><input type="password" name="password"></td><br/>
</tr>
<tr>
<td class="select">Users</td>
<td><select name="type">
	<option value="admin">Admin</option>
    <option value="Instructor">Instructor</option>
    <option value="Student">Student</option>
</select></td>
</tr>
<tr>
<td></td><td><input type="submit" value="Submit"></td></tr>
</table>
</div>

<div>
<%@ include file="footer.jsp" %>
</div>

</div>

</form>
</body>
</html>