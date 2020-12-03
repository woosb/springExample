<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center">
	<table border="1">
	    <tr>
	   <th>user</th>
	   <c:forEach var="u" items="${db_result.user }">
	       <td>${u.user_num }</td>
	   </c:forEach>
	    </tr>
	    <tr>
	   <th>system</th>
	   <c:forEach var="s" items="${db_result.system }">
	       <td>${s.system_num }</td>
	   </c:forEach>
	    </tr>
	</table>
	<a href="buy_form">결제 페이지 이동</a>
</div>
</body>
</html>