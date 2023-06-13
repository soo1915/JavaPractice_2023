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
	String sql = "update person set name = ?, addr = ?, phone = ? where id = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setString(1, name);
	ps.setString(2, addr);
	ps.setString(3, phone);
	ps.setInt(4, mid);
	
	int cnt = ps.executeUpdate();
	
%>
<form action="update.jsp">
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
		<td colspan = "2"><input type = "submit" value = "수정" /> </td>
	</tr>
</table>
</form>
</body>
</html>

