<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:set var="page" value="${pageContext.request.contextPath }"/>
<body>
<div align="center">
	<h1>Upload with Ajax</h1>
	<input type="file" name="uploadFile" multiple>
	<button id="uploadBtn">Upload</button>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function(){
		$("#uploadBtn").on("click", function(e){
			var formData = new FormData();
			var inputFile = $("input[name='uploadFile']");
			
			var files = inputFile[0].files;
			
			console.log(files);
			
			for(var i = 0; i <files.length; i++){
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax({
				url: '/root/uploadAjaxAction',
				processData: false,
				contentType: false,
				data: formData,
				type:'post',
				success: function(result){
					alert("Uploaded");
				}
			});
			
		});
	});
</script>
</html>