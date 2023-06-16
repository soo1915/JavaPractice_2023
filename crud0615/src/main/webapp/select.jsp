<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	th {background-color : cyan;}
	textarea { width : 100%;}
	.text {width : 100%;}
</style>
<title>Insert title here</title>
</head>
<body>
<%
	String num = request.getParameter("num");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String regtime = request.getParameter("regtime");
	String selectOption = request.getParameter("searchOption");
	String selectField = request.getParameter("searchField");
	int hits = 0;
%>

<table>
	<tr>
		<th class = "num" > 번호 </th>
		<th class = "title" > 제목 </th>
		<th class = "writer" > 작성자 </th>
		<th class = "regtime" > 작성일시 </th>
		<th>조회수</th>
	</tr>

<%
	String url = "jdbc:mariadb://localhost:3307/jspdb";
	String user = "root";
	String pass = "maria";
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이버 로딩!");
	Connection conn = DriverManager.getConnection(url, user, pass);
	System.out.println("접속 성공!");

	
	String sql = "select * from board where " + selectOption + " = " +selectField;
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	
	System.out.println(sql);
		while(rs.next()){
%>

	<tr>
		<td><%= rs.getInt("num") %></td>
		<td style = "text-align:left;">
				<%= rs.getString("title") %>
		</td>
		<td><%=rs.getString("writer")%></td>
		<td><%=rs.getString("regtime") %></td>
		<td><%=rs.getInt("hits") %></td>
	</tr>
<%
		}
%>	

</table>
<input type = "button" value = "목록보기" onclick="location.href='list.jsp'">


</body>
</html>