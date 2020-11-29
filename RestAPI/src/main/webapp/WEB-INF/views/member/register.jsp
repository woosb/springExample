<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div align="center">
	<form id="registerForm">
		id : <input type="text" name="id"><br>
		pw : <input type="text" name="pw"><br>
		<input type="hidden" id="addr" name="addr">
	</form>
	<input type="text"	id="addr1" placeholder="우편번호"><input type="button" value="우편번호 찾기" onclick="daumPost()"><br>
	<input type="text" id="addr2" placeholder="주소"><br>
	<input type="text" id="addr3" placeholder="상세주소">
	<input type="button" value="가입하기" onclick="register()">
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/daumPost/daumPost.js"></script>
<script>
function register(){
	postLoginForm();
	var result;
	$.ajax({	
	    url		: "/ajax/member/register",
	    data    : $("#registerForm").serialize(),
        dataType: "JSON",
        cache   : false,
        async   : false,
		type	: "POST",	
        success : function(data) {
        	result = data;
        },	       
        error 	: function(data) {
        	alert("회원가입 실패!");
        }
    });
	if(result === 1){
		console.log("1");
		self.location = "/member/login";
	}
}
</script>
</html>