<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "static0531.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<%
	//HandleStu.create();
	Singleton s1 = Singleton.getInstance();
	for (Student st : s1.stu) {
		out.println(st.name);
		out.println(st.kor);
		out.println(st.math);
		out.println(st.eng);
		out.println("<br/>");
	}
%>
</body>
</html>