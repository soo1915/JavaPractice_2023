<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post">
<c:forEach var="dept" items="${list}">
<label><input type="radio" name="deptno" value="${dept.deptno}">${dept.dname}</label>
</c:forEach>
<input type="submit" value="전송"/>
</form>
</body>
</html>