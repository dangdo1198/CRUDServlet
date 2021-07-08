package com.java;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addUser")
public class UserAddController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		UserDao userDao = new UserDao();
		User user = new User();
		 String firstname = req.getParameter("firstname");
		 String lastname  =req.getParameter("lastname");
		 String email =req.getParameter("email");
		
		 
		 user.setLastname(lastname);
		 user.setEmail(email);
		 user.setFirstname(firstname);
		 
		 userDao.addUser(user);
		resp.sendRedirect("ok");
		
	
	}
	

}
