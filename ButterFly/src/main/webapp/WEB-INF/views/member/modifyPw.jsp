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
	<h1>비밀번호 변경</h1>
	<form id="modifyForm">
		<input type="text" name="id" id="id" value="${id }" readonly><br>
		<input type="text" name="pw" id="pw"><br>
		<input type="button" value="변경하기" onclick="modifyPw()"><br>
	</form>
</div>
<script>
	function modifyPw(){
		$.ajax({
			url :"/member/modifyPw",
			data : $("#modifyForm").serialize(),
			dataType: "JSON",
			cache : false,
			async: false,
			type: "POST",
			success: function(data){
				redirect()			
			},
			error : function(data){
				redirect()
			}
		});
	}
	function redirect(){
		location.href="/member/login";
	}
</script>
<%@ include file="../includes/footer.jsp" %>
</body>

</html>