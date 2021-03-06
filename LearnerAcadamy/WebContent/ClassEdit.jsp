<%@page import="com.simplilearn.repository.ClassRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,com.simplilearn.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="classEditerHandler">

<%
List<Instructor> instructors=(List<Instructor>)session.getAttribute("instructorList"); 
List<Student> students=(List<Student>)session.getAttribute("studentList");
List<Course> courses=(List<Course>)session.getAttribute("courseList");
String command = request.getParameter("command");
Classes classes=new Classes();

	String id = request.getParameter("id");
	ClassRepository classRepository = new ClassRepository();
	classes=classRepository.findbyid(Integer.parseInt(id));

%>

<table>
<tr>
<td>Class Year:</td><td>
<input type="hidden" name="id" value=<%=classes.getId()%>>
<input type="text" name="c_year" value=<%=classes.getYear() %>></td>
</tr>
<tr>
<td>Semester:</td><td><input type="text" name="c_semester" value=<%=classes.getSemester() %>></td>
</tr>
<tr>
<td>Course:</td>
<td>
<select name="course" >
<% for(Course course:courses) {
	
%>
    <option value=<%=course.getId() %> <%=(course.getId()==classes.getCourse().getId())?"selected":""%> >
    <%=course.getTitle()%>
    </option> 
<% 
}
%>
</select>
</td>
</tr>
<tr>
<td>Instructor:</td><td>


<select name="instructor" >
<% for(Instructor instractor:instructors) { %>
    <option value=<%=instractor.getId() %> <%=(instractor.getId()==classes.getInstractor().getId())?"selected":""%> >
    <%=instractor.getFname() %>
    </option>
	 <%} %>
</select>

</td>
</tr>
<!--  <tr>

</tr>-->
<tr>
<td>
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