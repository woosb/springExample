<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="mem" items="${member }">
	id : <c:out value="${mem.id }"/>
	name : <c:out value="${mem.name }"/>
</c:forEach>
</body>
</html>