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
	<h3>업로드가 완료 되었습니다.</h3>
	<input type="text" name="id" value="${map.id }" readonly><br>
	<label>이름 : </label>
	<input type="text" name="name" value="${map.name }" readonly><br>
	<div>
		<c:forEach var="imageFileName" items="${map.fileList }">
			<c:out value="${imageFileName }"/>
			<img src="${path }/download?imageFileName=${imageFileName }" style="width:150px;">
			<a href="${path }/download?imageFileName=${imageFileName }">다운로드</a>
		</c:forEach>
	</div>
	<a href="${path }/form">다시 업로드 하기</a>
</div>

</body>
</html>