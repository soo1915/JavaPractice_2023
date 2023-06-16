<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	h2 {
		text-align : center;
	}
	table {
		margin-left : auto;
		margin-right : auto;
		border-top : 1px solid;
		border-collapse : collapse;
		width : 90%
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
<title>2023.06.16</title>
</head>
<body>
<h2> 테이블 조회 </h2>
<hr>
<br>
<form action = "view.jsp">
	<table >
		<tr>
			<th>글 번호</th>
			<th>글 제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
<%
	Class.forName("org.mariadb.jdbc.Driver");
	try(
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery("select * from sample_data order by num desc");
		) {while (rs.next()) {
			

%>

		<tr>
			<td><%= rs.getInt("num") %></td>
			<td>
				<a href = "view.jsp?num=<%=rs.getInt("num")%>">
					<%= rs.getString("title") %>
				</a>
			</td>
			<td><%= rs.getString("writer") %></td>
			<td><%= rs.getString("regtime") %></td>
			<td><%= rs.getString("hits") %></td>
		</tr>
<% 	
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>
	</table>
	<br>
	<div>
		<input type = "button" value = "글쓰기" onclick="location.href='write.jsp'"/>	
	</div>
</form>


</body>
</html>