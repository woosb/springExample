<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<%@ include file="includes/header.jsp" %>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<%@ include file="includes/footer.jsp" %>
</body>
</html>
