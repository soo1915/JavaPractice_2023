<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	//지정된 글 번호 얻기
	String num = request.getParameter("num");
	
	//게시글 데이터를 담을 변수 정의
	String writer = "";
	String title = "";
	String content = "";
	String regtime = "";
	int hits = 0;
	
// 	//지정된 글 번호를 가진 레코드 읽기
// 	Class.forName("org.mariadb.jdbc.Driver");
// 	try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb","root","maria");
// 			Statement stmt = conn.createStatement();
			
// 			//쿼리실행
// 			ResultSet rs = stmt.executeQuery(
// 					"select * from board where num="+num);)
// 			{
		
// 		if(num==null){
			
// 			String sql = String.format("insert into board(writer,title,content,regtime,hits) values('%s','%s','%s','%s',%d)",
// 					writer,title,content,regtime,hits);
// 			//out.print(sql);
// 			stmt.executeQuery(sql);
			
// 		}
// 		else if(num!=null){

// 			int num1 = Integer.parseInt(request.getParameter("num"));
// 			String sql = String.format("update board set writer='%s', title='%s', content='%s', regtime='%s', hits=%d where id=%d",
// 			writer,title,content,regtime,hits,num1);
// 			stmt.executeUpdate(sql);
		
// 		}
// 	}
// 		catch(Exception e){
// 		e.printStackTrace();
// 	}
	%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="write2.jsp">
number<input type="text" name="num" value="<%=num %>">
writer<input type="text" name="writer" value="<%=writer %>">
title<input type="text" name="title" value="<%=title %>">
content<input type="text" name="content" value="<%=content %>">
regtime<input type="text" name="regtime" value="<%=regtime %>">
<input type="submit" value="올리기" >
</form>
</body>
</html>