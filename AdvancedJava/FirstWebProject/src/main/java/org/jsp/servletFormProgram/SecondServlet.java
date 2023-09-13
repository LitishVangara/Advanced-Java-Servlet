package org.jsp.servletFormProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/SecondServlet")

public class SecondServlet extends GenericServlet
{
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException 
	{
		PrintWriter writer = response.getWriter();
		writer.println("<h1>Back end Code Executed.</h1>");
		writer.println("<h1 style='color:blue;'>Service Method Executed...</h1>");
		String temp = request.getParameter("eid");
		int id = Integer.parseInt(temp);
		String name = request.getParameter("ename");
		String temp2 = request.getParameter("esalary");
		double salary = Double.parseDouble(temp2);
		String temp3 = request.getParameter("dept");
		int deptNo = Integer.parseInt(temp3);
		writer.println("Name : "+name);
		writer.println("<br> Id : "+id);
		writer.println("<br> Salary : "+salary);
		writer.println("<br> DeptNo : "+deptNo);
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "insert into litishdatabase.employee values(?,?,?,?)";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1,id);
			ps.setString(2,name);
			ps.setDouble(3,salary);
			ps.setInt(4,deptNo);
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
