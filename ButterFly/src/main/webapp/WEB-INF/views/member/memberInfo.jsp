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
	<table>
		<tr>
			<td>id</td>
			<td>pw</td>
			<td>addr</td>
		</tr>
		<c:forEach items="${list }" var = "list">
			<tr>
				<td>${list.id }</td>
				<td>${list.pw }</td>
				<td>${list.addr }</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>