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
	<table border="1">
		<tr>
			<th>ID</th>
			<th>PW</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td><a href="/member/detail?id=${list.id }">${list.id }</a></td>
				<td>${list.pw }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>