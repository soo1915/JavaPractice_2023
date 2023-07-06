<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="backend0706.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원서 접수 사이트</title>
<style>
	body {
		text-align : center;
	}
	.buttondiv {
	
		text-align : center;
	}

</style>
</head>
<body>
	<h2>접수 홈페이지입니다.</h2>
	<hr>
	<br>
	<div class ="buttondiv">
		<button type = "button" class="btn1" onclick="location.href='resume.jsp'"> 접수하기</button>
		<button type = "button" class="btn1" onclick="location.href='list.jsp'" > 관리자모드 접속 </button>
	</div>
	
</body>
</html>