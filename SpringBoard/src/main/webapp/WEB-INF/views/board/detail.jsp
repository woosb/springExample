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
<form action="/board/modify" method="post">
	<table border="1">
		<tr>
			<th>번호</th>
			<td>${dto.id }</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${dto.hit }</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.name }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" value="${dto.title } " name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content">${dto.content }</textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="수정"></td>
			<td>
				<a href="/board/list">목록보기</a>
				<a href="/board/delete?id=${dto.id }">삭제</a>
				<a href="#" onclick="reply()">댓글작성</a>
			</td>
		</tr>
	</table>
	<input type="hidden" value="${dto.id }" name="id">
</form>
<div align="center" class="hidden" id="reply">
	<form action="/board/reply" method="post">
		<input type="text" name="content">
		<input type="hidden" name="title" value="${dto.title }">
		<input type="hidden" name="idgroup" value="${dto.idgroup }">
		<input type="hidden" name="step" value="${dto.step }">
		<input type="hidden" name="indent" value="${dto.indent }">
		<input type="submit" value="작성완료">
	</form>
</div>
</div>
<%@ include file="../includes/footer.jsp" %>
</body>
<style>
	.hidden{
		 visibility: hidden;
	}
	.visible{
		 visibility: visible;
	}
</style>
<script>
	function reply(){
		document.getElementById("reply").classList.add('visible');
	}
</script>
</html>