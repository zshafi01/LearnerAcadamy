package com.simplilearn.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilearn.model.Student;
import com.simplilearn.repository.StudentReposetory;

@WebServlet("/sudentEditerHandler")
public class sudentEditerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Student student = new Student();
		StudentReposetory studentReposetory = new StudentReposetory();

		student.setId(Integer.parseInt(request.getParameter("id")));
		student.setFname(request.getParameter("fname"));
		student.setLname(request.getParameter("lname"));
		boolean isupdated = studentReposetory.update(student);
		if(isupdated) {
			List<Student> students = studentReposetory.getAll();
			request.getSession().setAttribute("studentList", students);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("errorinfo", "Unable to edit course.");
			response.sendRedirect("Error.jsp");
		}}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
