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
Frist Name<input type="text" name="fname"><br/>
Last Name<input type="text" name="lname"><br/>
Email<input type="email" name="email"><br/>
Password<input type="password" name="password"><br/>

<select name="type">
	<option value="admin">Admin</option>
    <option value="Instructor">Instructor</option>
    <option value="Student">Student</option>

</select><br/>
<input type="submit" value="Submit">
</form>
</body>
</html>