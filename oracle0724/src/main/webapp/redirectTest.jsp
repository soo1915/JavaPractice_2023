<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String str = "홍길동";
String eval = URLEncoder.encode(str, "utf-8");
response.sendRedirect("aaa.jsp?name="+eval);
System.out.println(eval);
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