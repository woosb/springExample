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
	<input type="text" id="id" name="id" placeholder="아이디"><br>
	<input type="text" id="email" name="email" placeholder="이메일"><br>
	<input type="button" value="비밀번호 찾기" onclick="password()">
</div>
<%@ include file="../includes/footer.jsp" %>
<script>
function password(){
	var i = document.getElementById("id").value;
	var e = document.getElementById("email").value;
	var form = {id : i, email : e}
	
	$.ajax({
		url:"/member/password",
		type:"POST",
		data: form,
		dataType:"JSON",
		success: function(data){
			redirect();
		},
		error : function(data){
			redirect();
		}
	});	
}
function redirect(){
	location.href="/member/login";
}
</script>
</body>
</html>