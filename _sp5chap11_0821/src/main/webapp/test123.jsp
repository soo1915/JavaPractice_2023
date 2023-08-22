<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String arr[] = {"불고기", "닭고기", "소고기"};
	request.setAttribute("MENU", arr); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" items="${MENU}" varStatus="x">
${i}---${x.index}<br/>
</c:forEach>

</body>
</html>