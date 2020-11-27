<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/insert" method="post" id="insert">
		<input type="text" name="id"><br>
		<input type="text" id="addr1" placeholder="우편주소" name="name">
		<input type="button" onclick="daumPost()" value="우편번호 찾기"><br>
		<input type="text" id="addr2" placeholder="주 소"><br>
		<input type="text" id="addr3" placeholder="상세주소"><br>
		<br>
		<input type="button" value="submit" onclick="reg()">
	</form>
</body>
<script>
	function reg(){
		$('#addr1').val(
			$('#addr1').val()+'/'+ $('#addr2').val()+'/'+$('#addr3').val()
		)
		$('#insert').submit();
	}
</script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/member_js/daumpost.js"></script>
</html>