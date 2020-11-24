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
<h1>게 시 판</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>제목</th>
			<th>날짜</th>
			<th>조회수</th>
			<th>idgroup</th>
			<th>step</th>
			<th>indent</th>
		</tr>
		<c:forEach var="list" items="${list }">
			<tr>
				<td>${list.id }</td>
				<td>${list.name }</td>
				<td>
					<c:forEach begin="1" end="${list.indent}"> -> </c:forEach>
					<a href="/board/detail?id=${list.id }">${list.title }</a>
				</td>
				<td>${list.savedate }</td>
				<td>${list.hit }</td>
				<td>${list.idgroup }</td>
				<td>${list.step }</td>
				<td>${list.indent }</td>
			</tr>
		</c:forEach>
		<tr>
			<td><a href="/board/register">글 작성</a></td>
		</tr>
	</table>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script>
	if("${sessionScope.id}" == ""){
		alert("로그인이 필요합니다.")
		self.location="/member/login";
	}
</script>
</html>