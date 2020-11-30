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
<c:set var = "path" value="${pageContext.request.contextPath }"/>
<div align="center">
	<h3>파일 업로드</h3>
	<form action="${path }/upload" method="post" enctype="multipart/form-data">
		<label>아이디 : </label><input type="text" name="id"><br>
		<label>이름 : </label><input type="text" name="name"><br>
		<input type="file" name="file">
		<input type="submit" value="업로드">	
	</form> 
</div>
</body>
</html>