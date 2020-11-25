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
			<th>번호</th>
			<th>아이디</th>
			<th>접속</th>
			<th>종료</th>
			<th>사용시간</th>
		</tr>
		<c:forEach var="log" items="${log }">
			<tr>
				<td>${log.num }</td>
				<td>${log.id }</td>
				<td>${log.starttime }</td>
				<td>${log.endtime }</td>
				<td>${log.resulttime } 초</td>
			</tr>
		</c:forEach>
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