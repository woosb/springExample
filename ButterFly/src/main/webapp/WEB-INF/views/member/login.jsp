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
	<h2>로그인</h2>
	<form id="loginForm">
		<input type="text" name="id"><br>
		<input type="text" name="pw"><br>
		<input type="button" value="로그인" onclick ="login()">
		<input type="button" value="회원가입" onclick ="location.href='/member/join'">
		<input type="button" value="비밀번호 찾기" onclick ="location.href='/member/password'">
	</form>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script>
	function login(){
		var result;
		$.ajax({
			url :"/member/login",
			data : $("#loginForm").serialize(),
			dataType: "JSON",
			cache : false,
			async: false,
			type: "POST",
			success: function(data){
				result = data;
			},
			error : function(data){
				
			}
			
		});
		if(result === 1){
			self.location = "/";
		}else{
			alert(result);
		}
	}
</script>
</html>