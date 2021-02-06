package com.simplilearn.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;
import com.simplilearn.model.Instructor;
import com.simplilearn.repository.InstructorRepository;

/**
 * Servlet implementation class instructorHandler
 */
@WebServlet("/instructorHandler")
public class instructorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
//		Set<Classes> cls= request.getParameter("class");
		Instructor instructor = new Instructor();
		instructor.setFname(fname);
		instructor.setLname(lname);
	//	instructor.setClasses(cls);
		
		InstructorRepository instructorRepository = new InstructorRepository();
		
		boolean issaved = instructorRepository.insert(instructor);
		if(issaved==true) {
			List<Instructor>instructorList = instructorRepository.getAll();
			HttpSession session = request.getSession();
			session.setAttribute("instructorList", instructorList);
			
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
