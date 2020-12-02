<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>일</h1>
<h1>1</h1>
<h1>2</h1>
<h1>3</h1>
<h1>4</h1>
<h1>5</h1>

	이름 : <input type="text" id="n"><br>
	나이 : <input type="text" id="a"><br>
	<button type="button" onclick="ajaxTest()">ajax</button>
	<label id="result">0</label>


<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function ajaxTest(){
		//location.href = "count";
		var n = document.getElementById("n").value;
		var a = $("#a").val();
		var form = {name : n, age : a}
		$.ajax({
			url: "/ajax_json",
			type: "get",
//  			data: form,
			success: function(data){
				console.log(data)
				$("#result").text(data.id + " : " + data.pw);
			},
			error: function(){
				console.log("실패")
				alert("문제가 발생했습니다.")
			}
		});
	}
</script>
</body>
</html>