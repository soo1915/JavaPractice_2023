<%@ page import="util.Cookies" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	response.addCookie(Cookies.createCookie("name", "가나다"));
	response.addCookie(Cookies.createCookie("id", "abc", "/", 60));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>