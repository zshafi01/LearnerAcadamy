package com.simplilearn.handlers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.simplilearn.model.Instructor;
import com.simplilearn.repository.InstructorRepository;

@WebServlet("/instructorEditerHandler")
public class instructorEditerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Instructor instructor = new Instructor();
		InstructorRepository instructorRepository = new InstructorRepository();

		instructor.setId(Integer.parseInt(request.getParameter("id")));
		instructor.setFname(request.getParameter("fname"));
		instructor.setLname(request.getParameter("lname"));
		boolean isupdated = instructorRepository.update(instructor);
		if(isupdated) {
			List<Instructor> instructors = instructorRepository.getAll();
			request.getSession().setAttribute("instructorList", instructors);
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
