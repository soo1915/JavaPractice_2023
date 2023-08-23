<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
test1.jsp</br>
${val}

<form:form method="post" modelAttribute="code">
<p>
<%-- <label>코드<br><form:input path="code"/></label> --%>
<%-- 
<label>코드<br>
<form:select path="code">
<option value="" >-- 선택하세요 --</option>
<form:options items="${codeTypes}"/>
</form:select>
</label>
--%>
<%-- 
<form:select path="code">
	<form:option value="일반"/>
	<form:option value="기업">기업</form:option>
	<form:option value="헤드헌터" label="헤드헌터"/>
</form:select>
--%>
<form:select path="code">
<option value="" >-- 선택하세요 --</option>
<form:options items="${codeTypes }" itemLabel="label" itemValue="code"/>
</form:select>
<%-- <label>코드<br><form:select path="code" items="${codeTypes}"/> </label> --%>
</p>
<p>
<label>레이블<br><form:input path="label"/></label>
</p>
<input type="submit"/>
</form:form>
</body>
</html>