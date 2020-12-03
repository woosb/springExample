<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="includes/header.jsp" %>
<h1>
<c:if test="${userId != null }">
	<c:out value="${sessionScope.userId }"/>님 Hello world! 
</c:if>
<c:if test="${userId == null }">
	<a href="/member/login">로그인하기</a>
</c:if>
</h1>
<%@ include file="includes/footer.jsp" %>
</body>
</html>
