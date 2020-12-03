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
	<form id="password">
		<input type="text" name="id" placeholder="아이디">
		<input type="text" name="email" placeholder="이메일">
		<input type="button" value="비밀번호 찾기">
	</form>
</div>
<%@ include file="../includes/footer.jsp" %>
<script>
	$.ajax({
		url:"/member/password",
		type:"POST",
		data: $("#password").serialize(),
		dataType:"JSON",
		success: function(data){
			
		},
		error : function(data){
			
		}
	});
</script>
</body>
</html>