<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"  %>
<%
	String url = "jdbc:mariadb://localhost:3307/jspdb";
	String user = "root";
	String pass = "maria";
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이버 로딩!");
	Connection conn = DriverManager.getConnection(url, user, pass);
	System.out.println("접속 성공!");
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>person 데이터 리스트</h2>
<hr>
<form action = "select.jsp">
<table border = "1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>주소</td>
		<td>전화번호</td>
	</tr>
<%
	Statement stmt = conn.createStatement();
	String sql = "select * from person;";
	ResultSet rs = stmt.executeQuery(sql);
	while(rs.next()){
		int id = rs.getInt("id");
		String name = rs.getString("name");
		String addr = rs.getString("addr");
		String phone = rs.getString("phone");
%>
	<tr>
		<td><a href ="select.jsp?id=<%=id %>"><%=id %></a></td>
		<td><%=name %></td>
		<td><%=addr %></td>
		<td><%=phone %></td>
	</tr>
<% } %>
</table>
</form>




</body>
</html>