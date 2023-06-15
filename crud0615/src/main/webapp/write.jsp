<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%


	String num = request.getParameter("num");
	String writer = "";
	String title ="";
	String content = "";
	String regtime = "";
	int hits = 0;

// 	Class.forName("org.mariadb.jdbc.Driver");
// 	try (
// 			Connection conn = DriverManager.getConnection(
// 				"jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
// 		Statement stmt = conn.createStatement();

// 		ResultSet rs = stmt.executeQuery("select * from board where num=" + num);) 
// 	{
// 		//if(rs.next()) {
// 			//writer = rs.getString("writer");
// 			//title = rs.getString("title");
// 			//content = rs.getString("content");
// 			//regtime = rs.getString("regtime");
			
// 			//stmt.executeUpdate("Update board set hits=hits+1 where num = " + num);
// 		//}
// 		if(num == null) {
// 			String sql = String.format("insert into board values (%s, '%s', '%s', '%s', '%s', 0)", num, writer, title, content, regtime);
			
// 			stmt.executeUpdate(sql);
// 			System.out.println(sql);
			
			
// 		} else {
// 			String sql = String.format("update board set title = '%s', writer = '%s', regtime = '%s', content = '%s' where num = %s", title, writer, regtime, content, num);
// 			String action = num;
// 			stmt.executeUpdate(sql);
// 			System.out.println(sql);
// 			//response.sendRedirect("list.jsp");
			
// 		}		
// 		}catch(Exception e) {
// 			e.printStackTrace();
// 		}
		
	
%>
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

<h2> 글 작성</h2>
<hr>

<form action = "insertform.jsp">
<table>
	<tr>
		<th> 제목 </th>
		<td><input type = "text" name = "title" class = "text" value ="<%=title %>"/></td>
	</tr>
	<tr>
		<th>작성자</th>
		<td><input type = "text" name = "writer" class = "text" value ="<%=writer %>"/></td>
	</tr>
	<tr>
		<th>작성일시</th>
		<td><input type = "text" name = "regtime" class = "text" value ="<%=regtime %>"/></td>
	</tr>
	<tr>
		<th>내용</th>
		<td>
			<textarea rows = "10" name = "content" value ="<%=content %>"></textarea>
		</td>
	</tr>

</table>


<input type = "submit" value = "저장" onclick="location.href='list.jsp?num=<%=num%>'"/>
</form>
</body> 
</html>