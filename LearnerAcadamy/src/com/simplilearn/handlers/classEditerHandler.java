package com.simplilearn.handlers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.simplilearn.model.Classes;
import com.simplilearn.repository.ClassRepository;

@WebServlet("/classEditerHandler")
public class classEditerHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Classes classes = new Classes();
		ClassRepository classRepository = new ClassRepository();

		//classes.setId(Integer.parseInt(request.getParameter("id")));
		classes.setYear(request.getParameter("c_year"));
		classes.setSemester(request.getParameter("c_semester"));

		if (classRepository.update(classes)) {
			request.setAttribute("msg", "Successful");
		} else {
			request.setAttribute("msg", "Failed");
		}
		request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
