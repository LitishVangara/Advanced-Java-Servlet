package org.jsp.servletFormProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/ThirdServlet")

public class ThirdServlet extends GenericServlet
{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Back end Code Executed.</h1>");
		writer.println("<h1 style='color:blue;'>Service Method Executed...</h1>");
		String temp = request.getParameter("rollno");
		int rollNo = Integer.parseInt(temp);
		String name = request.getParameter("sname");
		String temp2 = request.getParameter("percentage");
		double percentage = Double.parseDouble(temp2);
		String stream = request.getParameter("stream");
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "insert into litishdatabase.student values(?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1,rollNo);
			ps.setString(2,name);
			ps.setDouble(3,percentage);
			ps.setString(4,stream);
			ps.executeUpdate();
			writer.println("<h1 style='color:blue;'>Registration Successfull.</h1>");
			connect.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}