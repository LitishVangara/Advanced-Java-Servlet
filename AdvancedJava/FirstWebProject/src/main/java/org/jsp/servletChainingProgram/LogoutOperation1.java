package org.jsp.servletChainingProgram;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutOperation1")

public class LogoutOperation1 extends HttpServlet
{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		//access the session
		HttpSession session = req.getSession();
		//fetch username from session object
		String firstName = (String) session.getAttribute("fn"); //downcasting
		String lastName = (String) session.getAttribute("ln"); //downcasting
		String email = (String) session.getAttribute("mail"); //downcasting
		PrintWriter writer = resp.getWriter();
		RequestDispatcher dispatcher = req.getRequestDispatcher("LoginOperation.html");
		dispatcher.include(req, resp);
		if (firstName != null) 
		{
			writer.println("<center><h1 style='color:purple;'> Thank you... "+firstName+" "+lastName+" for visiting the application.</h1></center>");
			writer.println("<center><h1 style='color:darkgreen;'>Logout Successfull... ("+email+")</h1></center>");
		}
		else
		{
			writer.println("<center><h1 style='color:red;'>Session Timeout...</h1></center>");
		}
	}
}
