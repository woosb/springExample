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
<div align ="center">
	<c:forEach var="list" items="${list }">
		num : <a href="delete?num=${list.num }">${list.num }</a><br>
		name : ${list.name}<br>
		mydate : ${list.mydate }<hr>
	</c:forEach>
</div>
</body>
</html>