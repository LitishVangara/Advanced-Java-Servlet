<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Action</title>
</head>
<body><center>
	<h1>Action JSP Element (Combine Multiple JSP File Output)</h1>
	<%
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		String onlyDate = dateFormat.format(date);
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("hh:mm:ss");
		String time = dateFormat1.format(date);
	%>
	<ins style="font-size:40px;">Long Date : <%= date%></ins>
	<br><br>
	<ins style="font-size:50px;">Short Date : <%= onlyDate%></ins>
	<br><br>
	<ins style="font-size:60px;">Time : <%= time%></ins>
	<br><br><hr><br>
	<h2 style="color:green;">Declaration.jsp file output</h2>
	<br><br>
	<jsp:include page="Declaration.jsp"></jsp:include>
	<br><hr><br>
	<h2 style="color:blue;">Demo.jsp file output</h2>
	<br><br>
	<jsp:include page="Demo.jsp"></jsp:include>
</center></body>
</html>