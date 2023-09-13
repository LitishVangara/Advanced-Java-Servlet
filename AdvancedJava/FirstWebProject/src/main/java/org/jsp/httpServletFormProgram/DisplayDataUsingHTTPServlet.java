package org.jsp.httpServletFormProgram;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DisplayDataUsingHTTPServlet")

public class DisplayDataUsingHTTPServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String temp = req.getParameter("dept");
		int deptNo = Integer.parseInt(temp);
		PrintWriter writer = resp.getWriter();
		writer.println("<h1>Selected DeptNo is : "+deptNo+"</h1>");
		
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "select * from litishdatabase.employee where deptNo=?";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection(url);
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1,deptNo);
			ResultSet rs = ps.executeQuery();
			int count = 0;
			while (rs.next())
			{
				writer.println("<h2>Record is Present.</h2>");
				String name = rs.getString("ename");
				int id = rs.getInt("eid");
				double salary = rs.getDouble("esalary");
				int dept = rs.getInt("deptNo");
				writer.println("<h2> Id = "+id);
				writer.println("<br> Name = "+name);
				writer.println("<br> Salary = "+salary);
				writer.println("<br> DeptNo = "+dept+"</h2>");
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
