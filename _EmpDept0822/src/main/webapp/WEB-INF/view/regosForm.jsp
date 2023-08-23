<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><spring:message code="member.register"/></h2>
<form:form method="post" modelAttribute="memberRegistRequest">
<p>
선호 OS</br>
<label><form:radiobuttons items="${osList }" path="favoriteOs"/></label>
</p>
<input type="submit"/>
</form:form>
</body>
</html>