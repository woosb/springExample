<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div align="center">
<h1>로그인</h1>
<form action="/member/login" method="post">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pw"></td>
		</tr>
	</table>
	<input type="submit" value="로그인">
</form>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script>
	var login =  "${login }";
	if(login == "success"){
		alert("로그인 성공!");
		self.location="/";
	}else if(login == "fail"){
		alert("로그인 실패");
		self.location=history.back();
	}
</script>
</html>