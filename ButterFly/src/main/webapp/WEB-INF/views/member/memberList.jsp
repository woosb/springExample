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
			<td>id</td>
			<td>startTime</td>
			<td>endTime</td>
			<td>resultTime</td>
		</tr>
		<c:forEach items="${list }"	 var="list">
		<tr>
			<td>${list.id }</td>
			<td>${list.startTime}</td>
			<td>${list.endTime }</td>
			<td>${list.resultTime}</td>
		</tr>
		</c:forEach>
	</table>
<%@ include file="../includes/footer.jsp" %>
</div>
</body>
</html>