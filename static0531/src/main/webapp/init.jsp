<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "static0531.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>init</title>
</head>
<body>
<%
HandleStu.create();
HandleStu.index = 0;
for (Student st : HandleStu.stu) {
	out.println(st);
}

%>
</body>
</html>