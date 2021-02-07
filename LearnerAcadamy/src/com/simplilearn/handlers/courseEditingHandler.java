package com.simplilearn.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.simplilearn.model.Course;
import com.simplilearn.repository.CourseRepository;

@WebServlet("/courseEditingHandler")
public class courseEditingHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Course course = new Course();
		CourseRepository courseRepository = new CourseRepository();

		course.setId(Integer.parseInt(request.getParameter("id")));
		course.setHours(Integer.parseInt(request.getParameter("c_hour")));
		course.setTitle(request.getParameter("c_name"));
		course.setPrice(Double.parseDouble(request.getParameter("c_price")));
		course.setDescription(request.getParameter("c_desc"));
		boolean isupdated = courseRepository.update(course);
		if(isupdated) {
			List<Course> courses = courseRepository.getAll();
			request.getSession().setAttribute("courseList", courses);
			request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("errorinfo", "Unable to edit course.");
			response.sendRedirect("Error.jsp");
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
