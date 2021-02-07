package com.simplilearn.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.simplilearn.model.Classes;
import com.simplilearn.model.Course;
import com.simplilearn.model.Instructor;
import com.simplilearn.repository.ClassRepository;
import com.simplilearn.repository.CourseRepository;
import com.simplilearn.repository.InstructorRepository;

@WebServlet("/classEditerHandler")
public class classEditerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Classes classes = new Classes();
		ClassRepository classRepository = new ClassRepository();
		CourseRepository courseRepository= new CourseRepository();
		InstructorRepository instructorRepository=new InstructorRepository();

		classes.setId(Integer.parseInt(request.getParameter("id")));
		classes.setYear(request.getParameter("c_year"));
		classes.setSemester(request.getParameter("c_semester"));
		
		String instructorid=request.getParameter("instructor");
		String courseid=request.getParameter("course");
		
		Course course= courseRepository.getById(Integer.parseInt(courseid));
		Instructor instructor=instructorRepository.getById(Integer.parseInt(instructorid));
		
		classes.setCourse(course);
		classes.setInstractor(instructor);
		
		boolean isupdated = classRepository.update(classes);
		if(isupdated) {
			List<Classes> classesList = classRepository.getAll();
			request.getSession().setAttribute("classesList", classesList);
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
