<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
member02/index.jsp
	<h3>get</h3>
	<form action ="result" method="get">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type= "submit" value="전송"><br>
	</form>
	
	<h3>post</h3>
	<form action="result" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type= "submit" value="전송"><br>
	</form>
	
	<h3>객체 전송(member)</h3>
	<form action="result01" method="post">
		<input type="text" name="name"><br>
		<input type="text" name="age"><br>
		<input type= "submit" value="전송"><br>
	</form>
</body>
</html>