package org.jsp.servletprogram;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/FirstServlet")

public class FirstServlet extends GenericServlet
{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		System.out.println("Back end Code Execution...");
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Back end Code Executed.</h1>");
		writer.println("<h1 style='color:blue;'>Service Method Executed...</h1>");
	}
}
