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
	try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb","root","maria");
			Statement stmt = conn.createStatement();
			
			//쿼리실행
			ResultSet rs = stmt.executeQuery(
					"delete from board where num="+num);){
		
	}
	
		catch(Exception e){
		e.printStackTrace();
	}%>

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

<p>
	삭제 성공! 리스트로 돌아가세요!
</p>
<input type = "button" value = "리스트보기" onclick="location.href='list.jsp'"/>



</body>
</html>