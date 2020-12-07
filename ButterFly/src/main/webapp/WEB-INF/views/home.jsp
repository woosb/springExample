<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body onload="getData()">
<%@ include file="includes/header.jsp" %>
<h1>
<c:if test="${userId != null }">
	<c:out value="${sessionScope.userId }"/>님 Hello world! 
</c:if>
<c:if test="${userId == null }">
	<a href="/member/login">로그인하기</a>
</c:if>
</h1>
	<div id="columnchart_material" style="width:800px; height:500px;" ></div>
<%@ include file="includes/footer.jsp" %>
</body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
   google.charts.load('current',{'packages':['bar']});
   google.charts.setOnLoadCallback(drawChart);
   function drawChart(){
      dataTable = new google.visualization.DataTable();
	  addData(dataTable);
      options={
         chart:{
            title:'사용자 로그인 현황',
         }
      }
      chart = new google.charts.Bar(document.getElementById('columnchart_material'))
      chart.draw(dataTable, google.charts.Bar.convertOptions(options))   
   }
   
    function addData(data){
    	data.addColumn('string', '시간별 로그')
		data.addColumn('number', '0~9초');
		data.addColumn('number', '10~19초');
		data.addColumn('number', '20~29초');
		data.addColumn('number', '30~39초');
		data.addColumn('number', '40~49초');
		data.addColumn('number', '50~59초');
		result.unshift("접속수");
		data.addRow(result);
		console.log(result);
    }

</script>
<script>
var result;
function getData(){
	$.ajax({
		url:"/common/getData",
		type:"POST",
		async:false,
		success: function(data){
			result = data;
			console.log(data);
		},
		error: function(data){
			
		}
	});
	return result;
}
</script>
</html>
