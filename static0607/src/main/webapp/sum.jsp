<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	int n = Integer.parseInt(num);
	int res = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border = "1">
	<tr>
		<td colspan = "2">구구단 <%=num %>단 결과</td>
	</tr>
	<%
	for (int i = 1; i<= 9; i++) {
		res = i * n;
	%>
	<tr>
		<td><%=num %> x <%= i %>
		<td><%= res %></td>	
	</tr>	
	<%
	}
	%>
	
	
</table>




</body>
</html>