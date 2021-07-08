package com.java;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/updateController")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		int id= Integer.parseInt(req.getParameter("id"));
	
		String email = req.getParameter("email");
		String fistName= req.getParameter("firstname");
		String lastName =req.getParameter("lastname");
		User user = new    User();
		user.setId(id);
		user.setEmail(email);
		user.setFirstname(fistName);
		user.setLastname(lastName);
		boolean check = new UserDao().updateUser(user);
		
		if(check) {
			
			resp.sendRedirect("ok");
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/detailUpdateUser.jsp");
			requestDispatcher.forward(req, resp);
			
		}
	
	}
	
}
