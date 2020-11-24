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
<div align="center">
	<form action="updatedata">
		존재하는 번호 : <input type="text" name="num">
		변경할 이름 : <input type="text" name='name'>
		변경할 날짜 : <input type="date" name="mydate">
		<input type="submit" value="저장">
	</form>
</div>
</body>
</html>