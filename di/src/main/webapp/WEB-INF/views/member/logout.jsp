<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String a = (String)request.getAttribute("logout"); %>
<%= a %>
${logout }
<br>
<a href="/member/login">로그인 페이지</a><br>
<a href="/member/index">기본 페이지</a>
</body>
</html>