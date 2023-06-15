<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 수정 데이터 확인 </h2>
<hr>
<%
	request.setCharacterEncoding("UTF-8");
	
	String sid = request.getParameter("id");
	int mid = Integer.parseInt(sid);
	String name = request.getParameter("name");
	String addr = request.getParameter("addr");
	String phone = request.getParameter("phone");

//select * from person where id = 번호
%>
<%
	String url = "jdbc:mariadb://localhost:3307/jspdb";
	String user = "root";
	String pass = "maria";
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이버 로딩!");
	Connection conn = DriverManager.getConnection(url, user, pass);
	System.out.println("접속 성공!");
%>
<%
	String sql = String.format("update person set name='%s', phone='%s', addr = '%s' where id = %s", name, phone, addr, mid);
	Statement stmt = conn.createStatement();
	stmt.executeUpdate(sql);
	response.sendRedirect("list.jsp");
%>
<form action="update.jsp">
<input type = "text" name = "id" value = "<%= mid %>"/>
<table border = "1">
	<tr>
		<td>아이디</td>
		<td><%=mid %>
	</tr>
	<tr>
		<td>이름</td>
		<td><%=name %>
	</tr>
	<tr>
		<td>주소</td>
		<td><%=addr %>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><%=phone %>
	</tr>
	<tr>
		<td colspan = "2"><input type = "button" value = "메인으로"/> </td>
	</tr>
</table>
</form>
</body>
</html>

