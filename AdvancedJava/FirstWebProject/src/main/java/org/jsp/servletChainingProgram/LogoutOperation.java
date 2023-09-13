package org.jsp.servletChainingProgram;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LogoutOperation")

public class LogoutOperation extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter writer = resp.getWriter();
		RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
		dispatcher.include(req, resp);
		writer.println("<center><h1 style='color:darkgreen;'>Logout Successfull...</h1></center>");
	}
}
