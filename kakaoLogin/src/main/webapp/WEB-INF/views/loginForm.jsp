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
<c:choose>
	<c:when test="${userId == null }">
		<form action="logincheck">
			<input type="text" name="id"><br>
			<input type="text" name="pwd"><br>
			<input type="submit" value="로그인"><br>
			<a href="https://kauth.kakao.com/oauth/authorize?client_id=234e520def8dd0c6d3a2b9dae6efb63b&redirect_uri=http://localhost:8181/success&response_type=code">
				<img width="200px" src="resources/images/kakao_btn.png">
			</a>
		</form>
	</c:when>
	<c:otherwise>
		${userId } 님 <a href="logout">로그아웃</a> 하세요
	</c:otherwise>
</c:choose>
</body>
</html>