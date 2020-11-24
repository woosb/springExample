<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>	
<div align="center">
	<form action="register" method="post">
		<table border="1">
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content" style="width:100; height:50"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성하기"></td>
			</tr>
		</table>
		<input type="hidden" name="name" value="${sessionScope.id }">
	</form>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>