<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>makdSession.jsp<br>
<h3>세션이 생성되었습니다</h3>
<hr>
id : ${id }<br>
session id : ${sessionScope.id }<br>
age : ${age }<br>
addr : ${sessionScope.addr }<br>
<hr>
<a href="resultSession">resultSession</a>
<a href="delSession">delSession</a>
</body>
</html>








