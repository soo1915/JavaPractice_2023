<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="person">
<p>이메일 : </br>
	<label>
	<form:input path="email"/>
	<form:errors path="email"/>
	</label>
</p>
<p>이름 : </br>
	<label>
	<form:input path="name"/>
	<form:errors path="name"/>
	</label>
</p>
<input type="submit"/>
</form:form>
</body>
</html>