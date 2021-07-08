package com.java;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ok")
public class UserController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		UserDao userDao = new UserDao();
		List<User> lisUsers = userDao.getAllUser();
		
		req.setAttribute("listUser", lisUsers);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
		requestDispatcher.forward(req, resp);
		
		
		
	
		
	}
	
}
