package com.simplilearn.handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.model.Classes;
import com.simplilearn.model.User;
import com.simplilearn.repository.ClassRepository;
import com.simplilearn.repository.UserRepository;

@WebServlet("/loginHandle")
public class loginHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		out.println("log in page");
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		UserRepository userRepository=new UserRepository();
		User user = userRepository.findbyemail(email);
		
		HttpSession session = request.getSession();
		session.setAttribute("userinfo", user);
		
		
		if(user!=null && user.getPassword().equals(password)) {
			ClassRepository classRepository=new ClassRepository();
			List<Classes>classesList = classRepository.getAll();
			session.setAttribute("classesList", classesList);
			response.sendRedirect("Dashboard.jsp");
		}else {
			session.setAttribute("errorinfo", "Either username or password is not correct.");
			response.sendRedirect("Error.jsp");
		}


	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
