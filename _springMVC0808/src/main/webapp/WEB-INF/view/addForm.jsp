<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/result" method="get">
	<input type = "text" name="num1"/>
	<input type = "text" name="num2"/>
	<input type = "submit"/>
</form>
</body>
</html>