<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">


<div>
<%@ include file="header.jsp" %>
</div>

<div>
<form method="post" action="loginHandle">

Email<input type="email" name="email"><br/>
Password<input type="password" name="password"><br/>


<input type="submit" value="Login">
</form>
</div>

<div>
<%@ include file="footer.jsp" %>
</div>

</div>


</body>
</html>