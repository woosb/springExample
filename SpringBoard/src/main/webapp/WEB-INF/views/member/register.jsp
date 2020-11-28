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
<form action="/member/register" method="post" id="insert">
	<table border="1">
		<tr>
			<th>ID</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>PW</th>
			<td><input type="text" name="pw"></td>
		</tr>
		<tr>
			<th><input type="button" onclick="daumPost()" value="주소검색"></th>
			<td><input type="text" id="addr1" placeholder="우편주소" name="name"></td>
			<td><input type="text" id="addr2" placeholder="주 소"></td>
			<td><input type="text" id="addr3" placeholder="상세주소"></td>
		</tr>
	</table>
	<input type="hidden" id="addr" name="addr">
	<input type="button" value="가입하기" onclick="reg()">
</form>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	function reg(){
		$('#addr').val(
			$('#addr1').val()+'/'+ $('#addr2').val()+'/'+$('#addr3').val()
		)
		$('#insert').submit();
	}
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function daumPost(){
    new daum.Postcode({
    	oncomplete: function(data) {
    		// 도로명일 경우  R, 지번일 경우 J 의 값을 가지고 있다.
    		console.log(data);
    		console.log('data.userSelectType : ' + data.userSelectedType);
    		console.log('data.roadAddress : ' + data.roadAddress);
    		console.log('data.jinunAddress : ' + data.jibunAddress);
    		console.log('data.zonecode(우편번호) : ' + data.zonecode);
    		
    		var addr = "";
    		if(data.userSelectedType === 'R'){
    			addr = data.roadAddress;
    		}else{
    			addr = data.jibunAddress;
    		}
    		
    		document.getElementById('addr1').value = data.zonecode;
    		$('#addr2').val(addr);
    		$('#addr3').focus();
    	}
    }).open();
}
</script>
<%@ include file="../includes/footer.jsp" %>
</body>
</html>