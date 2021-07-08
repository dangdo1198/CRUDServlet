package com.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeleteUser")
public class DeleteUserController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao user = new UserDao();
		int id = Integer.parseInt(req.getParameter("id"));
		boolean check = user.deleteUser(id);
	
		if(check) {
			resp.sendRedirect("ok");
			
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/home.jsp");
			requestDispatcher.forward(req, resp);
		}
		
	}
	
	
}
