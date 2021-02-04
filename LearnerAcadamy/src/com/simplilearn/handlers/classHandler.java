package com.simplilearn.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;
import com.simplilearn.repository.ClassRepository;
import com.simplilearn.repository.CourseRepository;

/**
 * Servlet implementation class classHandler
 */
@WebServlet("/classHandler")
public class classHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		//out.println("log in page");
	
		String year =request.getParameter("c_year");
		String c_semester=request.getParameter("c_semester");


		String instructorid=request.getParameter("instructor");
		String courseid=request.getParameter("course");
//		String studentid=request.getParameter("student");

		Classes classes = new Classes();
		classes.setYear(year);
		classes.setSemester(c_semester);
//		classes.setInstractor(instructor);
//		classes.setcourse(course);
//		classes.setstudent(student);
//		

		ClassRepository classRepository=new ClassRepository();
		boolean issaved = classRepository.insert(classes,Integer.parseInt(instructorid), Integer.parseInt(courseid));
		
		if (issaved==true) {
			List<Classes>classesList = classRepository.getAll();
			HttpSession session = request.getSession();
			session.setAttribute("classesList", classesList);
			response.sendRedirect("Dashboard.jsp");
		}else {
			response.sendRedirect("Error.jsp");
			
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
