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
	<h2>회원가입</h2>
	<form id="joinForm">
		<input type="text" name="id"><br>
		<input type="text" name="pw"><br>
		<input type="text" id="postNum" placeholder="우편번호"> &nbsp; <input type="button" onclick="daumPost()" value="우편번호 찾기"><br>
		<input type="text" id="address" placeholder="주소"><br>
		<input type="text" id="detail" placeholder="상세주소"><br>
		<input type="hidden" name="addr" id="addr">
		
		<input type="button" value="제출" onclick ="join()">
	</form>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function daumPost(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	if(data.addressType ==='R'){
		        	document.getElementById("address").value = data.roadAddress;
	        	}else{
	        		document.getElementById("address").value = data.jibunAddress;
	        	}
	        	document.getElementById("postNum").value = data.zonecode;
	        }
	    }).open();
	}
</script>
<script>
	function join(){
		var address = document.getElementById("address").value;
		var postNum = document.getElementById("postNum").value;
		var detail = document.getElementById("detail").value;
		var addr = document.getElementById("addr").value = address + "/ "+postNum+"/ "+detail; 
		
		console.log(addr);
		var result;
		$.ajax({
			url :"/member/join",
			data : $("#joinForm").serialize(),
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
			self.location = "/member/login";
		}else{
			alert(result);
		}
	}
</script>
</html>