package org.jsp.servletFormProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/FourthServlet")

public class FourthServlet extends GenericServlet
{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Back end Code Executed.</h1>");
		writer.println("<h1 style='color:blue;'>Service Method Executed...</h1>");
		String temp = request.getParameter("rollno");
		int rollNo = Integer.parseInt(temp);
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "select * from litishdatabase.student where RollNo=?";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1,rollNo);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next())
			{
				writer.println("<h2>Record is Present.</h2>");
				int rollNo1 = rs.getInt("RollNo");
				String name = rs.getString("StudentName");
				double percentage = rs.getDouble("Percentage");
				String stream = rs.getString("Stream");
				writer.println("<h2>Roll Number : "+rollNo1);
				writer.print("<br>Name : "+name);
				writer.print("<br>Percentage : "+percentage);
				writer.println("<br>Stream : "+stream+"</h2>");
				count++;
			}
			if (count==0)
			{
				writer.println("<h2 style='color:red;'>No Records Found.</h2>");
			}
			connect.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
