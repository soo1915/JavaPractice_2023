<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form method="post" modelAttribute="emp">
<p>이름 : </br>
<label><form:input path="ename"/></label>
</p>
<p>직무 : </br>
<label><form:input path="job"/></label>
</p>
<p>담당 매니저 : </br>
<label>
<form:select path="mgr">
<option value="99"> ---- 선택 ---- </option>
<form:options items="${empList}" itemLabel="ename" itemValue="empno"/>
</form:select>
</label>
</p>
<p>부서 : </br>
<label>
<form:select path="deptno" >
<option value="99"> ---- 선택 ---- </option>
<form:options items="${deptList}" itemLabel="dname" itemValue="deptno"/>
</form:select>
</label>
</p>
<p>급여 : </br>
<label><form:input path="sal"/></label>
</p>
<p>보너스(영업직에 한함) : </br>
<label><form:input path="comm"/></label>
</p>
<input type="submit" value="전송"/>
</form:form>
</body>
</html>