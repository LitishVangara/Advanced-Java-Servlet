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
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginOperation1")

public class LoginOperation1 extends HttpServlet
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
				//retrieve the data from DB
				String first = rs.getString("FirstName");
				String last = rs.getString("LastName");
				String mobileNo = rs.getString("MobileNumber");
				String email = rs.getString("Email");
				String pass = rs.getString("Password");
				System.out.println("Data retrieved from DB - Email ID = "+email);
				//access session object
				HttpSession session = req.getSession();
				System.out.println("Session object accessed...");
				//store users data in session object
				session.setAttribute("fn", first);
				session.setAttribute("ln", last);
				session.setAttribute("mn", mobileNo);
				session.setAttribute("mail", email);
				session.setAttribute("passw", pass);
				System.out.println("Data stored in Session...");
				//start the time interval
				session.setMaxInactiveInterval(10);
				RequestDispatcher dispatcher = req.getRequestDispatcher("MainPage.html");
				dispatcher.include(req, resp);
				String firstname = rs.getString("FirstName");
				writer.println("<center><h1 style='color:darkblue;'>Welcome "+first+" "+last+" </h1></center>");
				writer.println("<center><h1 style='color:darkgreen;'>Login Successfull...</h1></center>");
			}
			else
			{
				RequestDispatcher dispatcher = req.getRequestDispatcher("LoginOperation.html");
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
