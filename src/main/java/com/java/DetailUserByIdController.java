package com.java;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/DetailUser")
public class DetailUserByIdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao userDao = new UserDao();
		
		int id= Integer.parseInt(req.getParameter("id"));
		User user = userDao.getUserById(id);
		
		req.setAttribute("detailUser", user);
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/detailUpdateUser.jsp");
		requestDispatcher.forward(req, resp);
		

		
	}
}
