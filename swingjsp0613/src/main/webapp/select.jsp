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
<h2> 데이터 조회 </h2>
<hr>
<%
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
	String sql = "select * from person where id = '" + mid + "'";
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	if(rs.next()) {
		mid = rs.getInt("id");
		name = rs.getString("name");
		addr = rs.getString("addr");
		phone = rs.getString("phone");
	}
%>

<form action="update.jsp" method = "post">
<table border = "1">
	<tr>
		<td>아이디</td>
		<td><input type = "text" name = "id" value = <%=mid %>></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type = "text" name = "name" value = <%=name %>></td>
	</tr>
	<tr>
		<td>주소</td>
		<td><input type = "text" name = "addr" value = <%=addr %>></td>
	</tr>
	<tr>
		<td>전화번호</td>
		<td><input type = "text" name = "phone" value = <%=phone %>></td>
	</tr>
	<tr>
		<td colspan = "2"><input type = "submit" value = "수정" /> </td>
	</tr>
</table>
</form>
</body>
</html>