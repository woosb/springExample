<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<style type="text/css">
		ul li{	display:inline;	padding:0 10px; }
	</style>
</head>
<body>
	<div align="center" >
		<h1 style="color:burlywood; font-size:60px; font-family:Gabriola;">
			CARE &nbsp; LAB
		</h1>
	</div>
	<div align="right">
		<hr>
		<ul>
			<li><a href="/">HOME</a></li>
			<li>
				<c:if test="${userId != null }">
					<a href="/member/memberInfo">회원 정보</a>
				</c:if>
				<c:if test="${userId == null }">
					<a href="/member/login">회원 정보</a>
				</c:if>
			</li>
			<li>
				<a href="/board/boardAllList">게시판 </a>
			</li>
			<li>
				<c:if test="${userId != null }">
					<a href="/member/logout">로그아웃</a>
				</c:if>
				<c:if test="${userId == null }">
					<a href="/member/login">로그인</a>
				</c:if>
			</li>
			<li>
				<c:if test="${userId != null }">
					<a href="/member/memberList">회원로그</a>
				</c:if>
			</li>
		</ul>
		<hr>
	</div>
</body>
</html>