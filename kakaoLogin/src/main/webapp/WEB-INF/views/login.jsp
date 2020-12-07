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
<c:if test="${userId eq null }">
   <div style="margin:auto; width:300px;">
      <form action="loginCheck" method="post">
         <input type="text" name="id"><br>
         <input type="text" name="pwd"><br>
         <input type="submit" value="로그인">
         <a id="kakao-btn"></a>
      </form>
   </div>
</c:if>
<c:if test="${ userId ne null }">
   <h3>${userId }님 로그인 성공입니다.</h3>
</c:if>
<script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
<script type="text/javascript">
   Kakao.init("1f5211391784b11fe55f9471dd696710");
   Kakao.Auth.createLoginButton({
      container : "#kakao-btn",
      success: function(authObj){
         Kakao.API.request({
        	 url:'/v2/user/me',
        	 success:function(res){
        		 alert(JSON.stringify(res))
        		 console.log('아이디 : ' + res.id);
        		 console.log('이메일 : ' + res.kaccount_email);
        		 console.log('닉네임 : ' + res.properties['nickname']);
        		 console.log('토큰값 : ' + authObj.access_token);
        	 },
        	 fail: function(err){
        		 alert(JSON.stringify(err))
        	 }
         });
         
//          alert(authObj)
//          console.log('버튼생성 및 로그인 성공시 출력 : '+ JSON.stringify(authObj))
	
      }, fail: function(err){
         alert(JSON.stringify(err))
      }
   });
</script>
</body>
</html>





