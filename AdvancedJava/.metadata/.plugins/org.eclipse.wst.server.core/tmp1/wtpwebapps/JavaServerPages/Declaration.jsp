<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration</title>
</head>
<body>
	<!-- To create Global content - Global Variables and Methods (Declaration) -->
	<%!
		Connection connection; //Global Variable
		public Connection establishConnection() throws Exception
		{
			String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url);
			return connection;
		}
		public int deleteRecord(String CarNumber) throws Exception
		{
			String query = "delete from litishdatabase.cardetails where CarNumber=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, CarNumber);
			int record = ps.executeUpdate();
			return record;
		}
	%>
	<!-- To call methods and to execute code (Scriplet) -->
	<%
		establishConnection();
		int r = deleteRecord("YU89SD9");
		if(r>0)
		{
	%>
	<h1 style="color:green;">Record Deleted...</h1>
	<% 
		}
		else
		{
	%>
	<h1 style="color:red;">No Records Found...</h1>
	<% 	
		}
	%>
</body>
</html>