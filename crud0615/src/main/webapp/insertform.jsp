<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%


	String num = request.getParameter("num");
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String regtime = request.getParameter("regtime");
	int hits = 0;

	Class.forName("org.mariadb.jdbc.Driver");
	try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
		Statement stmt = conn.createStatement();

		ResultSet rs = stmt.executeQuery("select * from board where num=" + num);) 
	{
		//if(rs.next()) {
			//writer = rs.getString("writer");
			//title = rs.getString("title");
			//content = rs.getString("content");
			//regtime = rs.getString("regtime");
			
			//stmt.executeUpdate("Update board set hits=hits+1 where num = " + num);
		//}
		if(num == null) {
			String sql = String.format("insert into board (writer, title, content, regtime, hits) values ('%s', '%s', '%s', '%s', %d)", writer, title, content, regtime, hits);
			System.out.println(sql);
			stmt.executeUpdate(sql);
			
			
			
		} else if(num!=null){
			int num1 = Integer.parseInt(request.getParameter("num"));
			String sql = String.format("update board set title = '%s', writer = '%s', regtime = '%s', content = '%s' where num = %d", title, writer, regtime, content, num1);
			//String action = num;
			stmt.executeUpdate(sql);
			System.out.println(sql);
			//response.sendRedirect("list.jsp");
			
		}		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
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





</body>
</html>