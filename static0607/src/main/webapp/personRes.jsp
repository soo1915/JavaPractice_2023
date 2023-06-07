<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="jsp0607.*"%>
<%
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String birthday = request.getParameter("birthday");
	int bday = Integer.parseInt(birthday);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border = "2">
	<tr>
		<td colspan = "2">입력 정보 확인</td>
	</tr>
	<tr>
		<td>이름</td>
		<td><%= name %></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><%= address %></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%= phone %></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><%= email %></td>
	</tr>
	<tr>
		<td>생년월일</td>
		<td><%= bday %></td>
	</tr>
</table>
</body>
</html>