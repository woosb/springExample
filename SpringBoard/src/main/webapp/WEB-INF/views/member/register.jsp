<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="../includes/header.jsp" %>
<div align="center">
<h1>회원가입</h1>
<form action="/member/register" method="post">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pw"></td>
		</tr>
	</table>
	<input type="submit" value="가입하기">
</form>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<script>
	var result = ${result }
	if(result == 1){
		alert("회원가입이 성공적으로 완료 되었습니다.");
		self.location="login";
	}else{
		alert("회원가입에 실패하였습니다.");
		self.location=history.back();
	}
</script>
</html>