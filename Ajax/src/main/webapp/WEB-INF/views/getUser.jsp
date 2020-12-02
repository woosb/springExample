<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<span id="users">사용자 목록이 없습니다.</span>
	<hr>
	<button type="button" onclick="getUser()">사용자 목록 불러오기</button>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	var cnt = 1;
	
	function getUser(){
		$("button").text("목록 더 보기");
		$.ajax({
			url:"/users/"+cnt,
			type: "GET",
			success: function(list){
// 				$("#users").text(data);
				
				/*
				let html = "<br>아이디 : " + list[0].name + " 님<br>";
				html += "<b>나이 : </b>" + list[0].age + " 살<hr>";
				html += "<br>아이디 : </br>" + list[1].name + " 님<br>";
				html += "<b>나이 : </b>" + list[1].age + " 살<hr>";
				$("#users").html(html);
				*/
				let html="";
				$.each(list, function(index, item){
					html += "<br>아이디 : </br>" + item.name + " 님<br>";
					html += "<b>나이 : </b>" + item.age + " 살<hr>";
					$("#users").html(html);
				});
			},
			error: function(){
				alert("GET문제 발생");
			}
		});
	}
</script>
</html>