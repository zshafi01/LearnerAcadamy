<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logn in page</title>
</head>
<body>
<div class="container">


<div>
<%@ include file="header.jsp" %>
</div>

<div>
<form method="post" action="loginHandle">
<table>
<tr><td>Email<td><td><input type="email" name="email"><td></tr>
<tr><td>Password<td><td><input type="password" name="password"><td></tr>
<tr><td colspan="2"><input type="submit" value="Login"></td></tr>
</table>



</form>
</div>

<div>
<%@ include file="footer.jsp" %>
</div>

</div>


</body>
</html>