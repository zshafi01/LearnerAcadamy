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
classes:
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
	<td><%=classes.getInstractor().getFname() %></td>
	<td><%=classes.getCourse().getTitle() %></td>
	<td><a href="ClassEdit.jsp?command=edit&id=<%=classes.getId()%>">Edit</a></td>
	<td><a href="Class.jsp?command=delete&id=<%=classes.getId()%>">Delete</a></td></tr>
	
</tr>
<%} %>
</tbody>
</table>
<%} %>

<hr>
course:
<table>
<tr><th>Title</th><th>Hours</th><th>Price</th><th></th><th></th></tr>
<%
List<Course> courses=(List<Course>)session.getAttribute("courseList");
if(courses!=null && !courses.isEmpty()){
for(Course course:courses)
{
%>
<tr><td><%=course.getTitle() %></td><td><%=course.getHours() %></td><td><%=course.getPrice() %></td>
<td><a href="CourseEdit.jsp?command=edit&id=<%=course.getId()%>">Edit</a></td>
<td><a href="Course.jsp?command=delete&id=<%=course.getId()%>">Delete</a></td></tr>
<%}} %>
</table>
<hr>
Instructor:
<table>
<tr><th>First name</th><th>Last name</th><th></th><th></th></tr>
<%
List<Instructor> instructors=(List<Instructor>)session.getAttribute("instructorList");
if(instructors!=null && !instructors.isEmpty()){
for(Instructor instructor:instructors)
{
%>
<tr><td><%=instructor.getFname() %></td><td><%=instructor.getLname() %></td>
<td><a href="InstructorEdit.jsp?command=edit&id=<%=instructor.getId() %>">Edit</a></td>
<td><a href="Instructor.jsp?command=delete&id=<%=instructor.getId() %>">Delete</a></td>
</tr>
<%}} %>
</table>
<hr>
student:
<table>
<tr><th>First name</th><th>Last name</th><th></th><th></th></tr>
<%
List<Student> students=(List<Student>)session.getAttribute("studentList");
if(students!=null && !students.isEmpty()){
for(Student student:students)
{
%>
<tr><td><%=student.getFname() %></td><td><%=student.getLname() %></td>
<td><a href="StudentEdit.jsp?command=edit&id=<%=student.getId()%>">Edit</a></td>
<td><a href="Student.jsp?command=delete&id=<%=student.getId()%>">Delete</a></td>
</tr>
<%} }%>
</table>

</div>

<div>
<%@ include file="footer.jsp" %>
</div>

</div>
</body>
</html>