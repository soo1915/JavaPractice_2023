<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table { width : 680px; text-align : center;}
	th { background-color:cyan;}
	.num {width : 80px;}
	.title {width : 230px;}
	.writer {width : 100px;}
	.regtime {width : 180px;}
	
	a:link { text-decoration:none; color:blue;}
	a:visited { text-decoration:none; color:gray;}
	a:hover { text-decoration:none; color:red;}
</style>
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<th class = "num" > 번호 </th>
		<th class = "title" > 제목 </th>
		<th class = "writer" > 작성자 </th>
		<th class = "regtime" > 작성일시 </th>
		<th>조회수</th>
	</tr>
	
<%
	Class.forName("org.mariadb.jdbc.Driver");
	try (
		Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
		Statement stmt = conn.createStatement();
			
		ResultSet rs = stmt.executeQuery(
				"select * from board order by num desc");	
		){
		while (rs.next()) {
%>			
	<tr>
		<td><%= rs.getInt("num") %></td>
		<td style = "text-align:left;">
			<a href = "view.jsp?num=<%=rs.getInt("num")%>">
				<%= rs.getString("title") %>
			</a>
		</td>
		<td><%=rs.getString("writer")%></td>
		<td><%=rs.getString("regtime") %></td>
		<td><%=rs.getInt("hits") %></td>
	</tr>
<% 	
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
%>

	
	
</table>

<form action = "select.jsp">
	<table>
		<tr>
		<td>
			<input type = "button" value="글쓰기" onclick="location.href='write.jsp'">
		</td>
		<td></td>
		<td>
			<select name = "searchOption">
				<option value = "0"> 선택</option>
				<option value = "num"> 글번호</option>
				<option value = "writer"> 작성자</option>
				<option value = "title"> 제목 </option>
			</select>
		</td>
		<td>
			<input type = "text" name = "searchField" placeholder = "검색어 입력" maxlength="100"/>
		</td>
		<td>
			<input type = "submit" value = "검색하기"/>	
			
		</td>	
	</tr>
	</table>
</form>

<br>







</body>
</html>