package com.simplilearn.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.model.Instructor;
import com.simplilearn.model.Student;
import com.simplilearn.repository.InstructorRepository;
import com.simplilearn.repository.StudentReposetory;


@WebServlet("/sudentHandler")
public class sudentHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
//		Set<Classes> cls= request.getParameter("class");
		Student student = new Student();
		student.setFname(fname);
		student.setLname(lname);
	//	student.setClasses(cls);
		
		StudentReposetory studentReposetory = new StudentReposetory();
		
		boolean issaved = studentReposetory.insert(student);
		if(issaved==true) {
			List<Student>studentList = studentReposetory.getAll();
			HttpSession session = request.getSession();
			session.setAttribute("studentList", studentList);
			response.sendRedirect("Dashboard.jsp");
		}else {
			response.sendRedirect("Error.jsp");
		
	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
