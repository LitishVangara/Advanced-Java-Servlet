<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Information</title>
<style>
	table,td,th
	{
		border:3px solid black;
		padding:20px;
		border-color:red;
	}
</style>
</head>
<body style='background-color:bisque;'>
	<%
		String carColor = request.getParameter("color");
	%>
	<center><h1 style='color:blue;'>Car Color is : <%= carColor%></h1></center>
	<%
		//jdbc code
		String url = "jdbc:mysql://localhost:3306?user=root&password=Litish17@";
		String query = "select * from litishdatabase.cardetails where CarColor=?";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1,carColor);
		ResultSet rs = ps.executeQuery();
		//to check weather first record is present in resultant data or not
		boolean status = rs.isBeforeFirst();
		if (status)
		{
			//records are present - color is valid
			//retrieve the data
	%>
	<center>
		<table style="border-collapse: collapse; width: 100%; font-size:30px; outline:3px solid black; background-color:rgb(190, 243, 243);">
			<tr style='color:green;'>
				<th><b>Car No : </b></th>
				<th><b>Color : </b></th>
				<th><b>Brand : </b></th>
			</tr>
	<%
		while(rs.next())
		{
			String color = rs.getString("CarColor");
			String carNo = rs.getString("CarNumber");
			String brand = rs.getString("CarBrand");
	%>
			<tr style='color:blue;'>
				 <td><center><b><%= carNo%></b></center></td>
				 <td><center><b><%= color%></b></center></td>
				 <td><center><b><%= brand%></b></center></td>
			</tr>
	<%
		}//close the while loop
	%>
		</table>
		<br><hr><br>
		<jsp:include page="Delete.jsp"></jsp:include>
	</center>
	<%
		}//close the if block
		else
		{
			//records are not present - color is invalid
	%>
	<!-- Link one JSP file with another -->
	<jsp:forward page="Frontend.jsp">
	<jsp:param value="Invalid Color... No Records Found..." name="message"/>
	</jsp:forward>
	<%
		}//close the else block
		connection.close();
	%>
</body>
</html>