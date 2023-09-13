<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Color</title>
<style>
	input
	{
		font-size:40px;
		align:center;
	}
</style>
</head>
<body>
	<center>
		<!-- to access forwarded of Backend.jsp file (Expression Language) -->
		<h1 style="color:red;">${param.message }</h1>
		<form action="Backend.jsp">
			<input type="text" placeholder="Enter Color of Car" name="color">
			<br><br>
			<input type="submit" value="Display">
		</form>
	</center>
</body>
</html>