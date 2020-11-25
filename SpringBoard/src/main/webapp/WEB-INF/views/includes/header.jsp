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
<div align="center" >
<h1 style="color:burlywood; font-size:60px; font-family:Gabriola;">
CARE &nbsp; LAB
</h1>
	<hr>
		<div style="float:left; margin-right: 10px;">
			<a href="/">HOME</a>
		</div>	
		<div style="float:right; display: flex;">
			<c:choose>
				<c:when test ="${sessionScope.id eq null }">
					<div style="margin-right : 10px;">
						<a href="/member/login" >SIGN IN</a>
					</div>
					<div style="margin-right : 10px;">
						<a href="/member/register">SIGN UP</a>
					</div>
				</c:when>
				<c:otherwise>
					<div style="margin-right : 10px;">
						<a href="/member/logout" >SIGN OUT</a>
					</div>
				</c:otherwise>
			</c:choose>
		</div>
		<div style="display:flex;">
			<div style="margin-right : 10px;">
				<a href="/board/list">boardList</a>
			</div>
			<div style="margin-right : 10px;">
				<a href="/member/list">memberList</a>
			</div>
			<div style="margin-right : 10px;">
				<a href="/member/log">로그보기</a>
			</div>
		</div>
	<hr>
</div>
</body>
</html>