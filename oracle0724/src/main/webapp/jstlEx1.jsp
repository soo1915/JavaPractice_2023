<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setAttribute("name", "홍길동");
request.setAttribute("money", 15000);
request.setAttribute("dataList", new String[] {"a", "b", "c"});
%>
<%-- JSP 주석 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html 주석 -->
<c:if test="${name == '홍길동'}">
이름이 홍길동입니다<br/>
</c:if>
<c:choose>
<c:when test="${money >= 10000}">
돈 많아요.<br/>
</c:when>
<c:when test="${money > 0}">
돈이 조금 있어요.<br/>
</c:when>
<c:otherwise>
돈이 하나도 없어요.
</c:otherwise>
</c:choose>
<c:forEach var="count" begin="1" end="10" step="2">
${count}
</c:forEach>
<c:forEach var="data" items="${dataList}">
${data}
</c:forEach>
</body>
</html>




