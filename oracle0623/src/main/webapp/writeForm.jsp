<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	String name = "";
	int kor = 0;
	int eng = 0;
	int math = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table     { width:auto; text-align:center; }
	th        { background-color:cyan; }
        
    .num      { width:80px; }
    .name     { width:100px; }
    .kor      { width:80px; }
    .eng      { width:80px; }
    .math     { width:80px; }
            
    a:link    { text-decoration:none; color:blue; }
    a:visited { text-decoration:none; color:gray; }
    a:hover   { text-decoration:none; color:red;  }
</style>
<title>Insert title here</title>
</head>
<body>
<h2> 점수 입력</h2>
<hr>
<form action = "write.jsp">
	<table>
		<tr>
			<th> 이름 </th>
			<td> <input type = "text" name = "name" /></td>
		</tr>
		<tr>
			<th> 국어 </th>
			<td> <input type = "text" name = "kor"/></td>
		</tr>
			<tr>
			<th> 영어 </th>
			<td> <input type = "text" name = "eng"/></td>
		</tr>
			<tr>
			<th> 수학 </th>
			<td> <input type = "text" name = "math"/></td>
		</tr>
	</table>
	<input type = "submit" value="전송"/>
</form>
</body>
</html>