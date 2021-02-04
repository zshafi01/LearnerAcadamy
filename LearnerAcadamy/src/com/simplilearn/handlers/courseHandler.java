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

import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;
import com.simplilearn.model.User;
import com.simplilearn.repository.CourseRepository;
import com.simplilearn.repository.UserRepository;

/**
 * Servlet implementation class courseHandler
 */
@WebServlet("/courseHandler")
public class courseHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out= response.getWriter();
		//out.println("log in page");
		
		String c_name=request.getParameter("c_name");
		Integer c_hour= Integer.parseInt(request.getParameter("c_hour"));
		Double c_price=Double.parseDouble(request.getParameter("c_price"));
		String c_desc=request.getParameter("c_desc");

//		String instructor=request.getParameter("instructor");
//		String classes =request.getParameter("class");

		Course course = new Course();
		course.setTitle(c_name);
		course.setHours(c_hour);
		course.setPrice(c_price);
		course.setDescription(c_desc);
		CourseRepository courseRepository=new CourseRepository();
		boolean issaved = courseRepository.insert(course);
		
		if (issaved==true) {
			List<Course>coursesList = courseRepository.getAll();
			HttpSession session = request.getSession();
			session.setAttribute("courseList", coursesList);
			response.sendRedirect("Dashboard.jsp");
		}else {
			response.sendRedirect("Error.jsp");
			
		}}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
