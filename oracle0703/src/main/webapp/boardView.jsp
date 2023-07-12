<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "1">
<c:forEach var="dao" items="${list }">
	<tr>
		<td>${dao.writer}</td>
		<td>${dao.title }</td>
		<td>${dao.content }</td>
		<td>${dao.regtime }</td>
		<td>${dao.hits }</td>
	</tr>
</c:forEach>
</table>
</body>
</html>