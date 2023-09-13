package org.jsp.servletChainingProgram;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginOperation")

public class LoginOperation extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String mobile = req.getParameter("mob");
		String password = req.getParameter("pwd");
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "select * from litishdatabase.userdetails where MobileNumber=? and Password=?";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, mobile);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			PrintWriter writer = resp.getWriter();
			if (rs.next()) 
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("Main.html");
				dispatcher.include(req, resp);
				String firstname = rs.getString("FirstName");
				writer.println("<center><h1 style='color:darkblue;'>Welcome "+firstname+"...</h1></center>");
				writer.println("<center><h1 style='color:darkgreen;'>Login Successfull...</h1></center>");
			}
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("Login.html");
				dispatcher.include(req, resp);
				writer.println("<center><h1 style='color:red;'>Enter Valid Credentials...</h1></center>");
			}
			connect.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
