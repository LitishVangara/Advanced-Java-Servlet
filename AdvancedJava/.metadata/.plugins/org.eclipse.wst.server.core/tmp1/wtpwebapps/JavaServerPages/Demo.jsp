<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h1 style='color:blue; font-size:50px;'> JAVA SERVER PAGES (HTML CODE OUTPUT) </h1>
		<!-- to write java code injsp file (scriplets) -->
		<%  
			//java code
			String subject = "Java Server Pages";
			int classRoomNo = 501;
		%>
		<!-- to print the output of java code (Expression) -->
		<h1 style='color:red; font-size:60px;'> Output of Java Code : <%= subject %></h1>
		<em style='color:green; font-size:60px;'> Class Room : <%= classRoomNo %></em>
	</center>
</body>
</html>