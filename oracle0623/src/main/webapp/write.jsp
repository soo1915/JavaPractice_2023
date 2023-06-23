<%@page import="oracle0623.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String name = request.getParameter("name");
	int kor = Integer.parseInt(request.getParameter("kor"));
	int eng = Integer.parseInt(request.getParameter("eng"));
	int math = Integer.parseInt(request.getParameter("math"));
	
	ScoreDao dao = new ScoreDao();
	ScoreServiceImp service = new ScoreServiceImp();
	
	int num = service.createScore(name, kor, eng, math);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=num + 1 %>번 데이터로 입력 성공! 목록으로 이동하세요!</p>
<input type = "button" value="목록으로" onclick="location.href='list.jsp'">
</body>
</html>