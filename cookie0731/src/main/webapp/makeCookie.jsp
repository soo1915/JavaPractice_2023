<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie ("name1", "abcd1");
	response.addCookie(cookie);
	cookie = new Cookie("name2", "abcd2");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= cookie.getName() %> = <%= cookie.getValue() %><br>
<%= cookie.getName() %> = <%= cookie.getValue() %>
</body>
</html>