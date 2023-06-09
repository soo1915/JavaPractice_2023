<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int empno = Integer.parseInt(request.getParameter("empno"));
	String ename = request.getParameter("ename");
	int sal = Integer.parseInt(request.getParameter("sal"));
	String phone = request.getParameter("phone");
%> 
<%
	Connection conn = null;
	String url = "jdbc:mariadb://localhost:3307/jspdb";
	String user = "root";
	String pass = "maria";
	Class.forName("org.mariadb.jdbc.Driver");
	System.out.println("드라이버 로딩!");
	conn = DriverManager.getConnection(url, user, pass);
	System.out.println("접속 성공!");
%>

<%
	String sql = "INSERT INTO emp VALUES (" + empno + ", \"" + ename +"\"," + sal + ",\"" + phone + "\")";
	System.out.println(sql);
	Statement stmt = conn.createStatement();
	stmt.executeUpdate(sql);
	System.out.println("query 성공");
%>
	
<h2> 입력된 데이터 </h2>
<hr>
<table border = "2">
	<tr>
		<td>empno</td>
		<td><%=empno %>
	</tr>
	<tr>
		<td>ename</td>
		<td><%=ename %>
	</tr>
	<tr>
		<td>sal</td>
		<td><%=sal %>
	</tr>
	<tr>
		<td>phone</td>
		<td><%=phone %>
	</tr>	
</table>


</body>
</html>