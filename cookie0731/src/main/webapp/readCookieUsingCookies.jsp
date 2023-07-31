<%@page import="util.Cookies"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookies cookies = new Cookies(request);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if (cookies.exists("id")) { %>
<%=cookies.getValue("id")%><br>
<% } %>

<% if (cookies.exists("name")) { %>
<%=cookies.getValue("name")%><br>
<% } %>
</body>
</html>