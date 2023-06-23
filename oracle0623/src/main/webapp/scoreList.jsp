<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="oracle0623.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table     { width:680px; text-align:center; }
	th        { background-color:cyan; }
	
	.num      { width:80px; }
	.name     { width:100px; }
	.kor      { width:80px; }
	.eng      { width:80px; }
	.math     { width:80px; }
	        
	a:link    { text-decoration:none; color:blue; }
	a:visited { text-decoration:none; color:gray; }
	a:hover   { text-decoration:none; color:red;  }
</style>
<title>Insert title here</title>
</head>
<body>
<h2> 학생별 총점 & 평균</h2>
<hr>
<table>
    <tr>
        <th class="num" >번호</th>
        <th class="name">이름</th>
        <th class="kor" >국어</th>
        <th class="eng" >영어</th>
        <th class="math">수학</th>
        <th class="sum" >총점</th>
        <th class="avg" >평균</th>
    </tr>   
    <%
	ScoreServiceImp service = new ScoreServiceImp();
    ArrayList<ScoreDto> list = service.studentList();
	for (ScoreDto dto : list) {
	%>         
        <tr>
            <td><%=dto.getNum() %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getKor() %></td>
            <td><%=dto.getEng() %></td>
            <td><%=dto.getMath() %></td>
            <td><%=dto.getSum() %></td>
            <td><%=dto.getAvg() %></td>
        </tr>
	<%
	
	    }
	%>
</table>
</body>
</html>