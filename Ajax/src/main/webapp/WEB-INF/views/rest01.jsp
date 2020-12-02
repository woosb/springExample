<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<label>버튼을 클릭하세요</label>
<hr>
<button type="button" onclick="ajaxGet()">Get</button>
<button type="button" onclick="ajaxPost()">Post</button>
<button type="button" onclick="ajaxPut()">Put</button>
<button type="button" onclick="ajaxDelete()">Delete</button>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function ajaxGet(){
		$.ajax({
			url:"rest",
			type: "GET",
			success: function(data){
				$("label").text(data);
			},
			error: function(){
				alert("GET문제 발생");
			}
		});
	}
	function ajaxPost(){
		$.ajax({
			url:"rest",
			type: "POST",
			success: function(data){
				$("label").text(data);
			},
			error: function(){
				alert("POST문제 발생");
			}
		});
	}
	function ajaxPut(){
		$.ajax({
			url:"rest",
			type:"PUT",
			success: function(data){
				$("label").text(data);
			},
			error: function(){
				alert("PUT문제 발생");
			}
		});
	}
	function ajaxDelete(){
		$.ajax({
			url:"rest",
			type:"DELETE",
			success: function(data){
				$("label").text(data);
			},
			error: function(){
				alert("DELETE문제 발생");
			}
		});
	}
</script>
</html>