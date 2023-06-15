<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%
	//지정된 글 번호 얻기
	String num = request.getParameter("num");
	
	
	//게시글 데이터를 담을 변수 정의
	String writer = request.getParameter("writer");
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	String regtime = request.getParameter("regtime");
	int hits = 0;
	
	//지정된 글 번호를 가진 레코드 읽기
	Class.forName("org.mariadb.jdbc.Driver");
	try(Connection conn=DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb","root","maria");
			Statement stmt = conn.createStatement();
			
			//쿼리실행
			ResultSet rs = stmt.executeQuery(
					"select * from board where num="+num);)
			{
		
		if(num==null){
			
			String sql = String.format("insert into board(writer,title,content,regtime,hits) values('%s','%s','%s','%s',%d)",
					writer,title,content,regtime,hits);
			System.out.println(sql);
			stmt.executeQuery(sql);
			
		}
		else if(num!=null){

			int num1 = Integer.parseInt(request.getParameter("num"));
			String sql = String.format("update board set writer='%s', title='%s', content='%s', regtime='%s', hits=%d where id=%d",
			writer,title,content,regtime,hits,num1);
			System.out.print(sql);
			stmt.executeUpdate(sql);
		
		}
	}
		catch(Exception e){
		e.printStackTrace();
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>