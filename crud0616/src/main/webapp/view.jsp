<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
	String num = request.getParameter("num");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String regtime = request.getParameter("regtime");
	String hits = request.getParameter("hits");

%>
<%
	Class.forName("org.mariadb.jdbc.Driver");
	try(
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from sample_data where num = " + num);
		) { if (rs.next()) {
			writer = rs.getString("writer");
			regtime = rs.getString("regtime");
			title = rs.getString("title");
			content = rs.getString("content");
			
			title = title.replace(" ", "&nbsp;");
			content = content.replace(" ", "&nbsp;");
			
			stmt.executeQuery("update sample_data set hits = hits + 1 where num = " + num);
		}
	}
%>
<style>
	h2 {
		text-align : center;
	}
	table {
		margin-left : auto;
		margin-right : auto;
		border-top : 1px solid;
		border-collapse : collapse;
	}
	th {
		text-align : center; 
		background-color : #e0ffff;
		border-bottom : 1px solid;
		border-left : 1px solid;
		padding : 10px;
	}
	td {
		text-align : center;
		border-bottom: 1px solid;
		border-left: 1px solid;
		padding : 10px;
	}
	th:first-child, td:first-child {
		border-left : none;
	}
	div {
		text-align : center;
	}
</style>
<title>Insert title here</title>
</head>
<body>
<h2> 글 내용 </h2>
<hr>
<form>
	<table>
		<tr>
			<th>작성자</th>
			<td><%=writer %></td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td><%=regtime %></td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><%=title %></td>
		</tr>
		<tr>
			<th>글내용</th>
			<td><%=content %></td>
		</tr>
	</table>
	<br>
	<div>
		<input type = "button" value = "메인으로" onclick = "location.href='list.jsp'"/>
		<input type = "button" value = "수정하기"/>
		<input type = "button" value = "삭제하기"/>
	</div>
</form>
</body>
</html>