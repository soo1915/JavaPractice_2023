<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="oracle0623.*" %>
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
<h2>분석</h2>
<hr>
<table>
    <tr>
    	<th colspan = "3">과목별 최대값</th>
    </tr>
    <tr>
    	<th> 국어 </th>
    	<th> 영어 </th>
    	<th> 수학 </th>
    </tr>
	<%
	ScoreServiceImp service = new ScoreServiceImp();
	NumberDto dto1 = service.selectMaxAnalyze();
	
	%>
    <tr>
    	 <td><%=dto1.getKor() %></td>
    	 <td><%=dto1.getEng() %></td>
    	 <td><%=dto1.getMath() %></td>
    </tr>

</table>
<br>
<hr>
<table>
    <tr>
    	<th colspan = "3">과목별 평균</th>
    </tr>
    <tr>
    	<th> 국어 </th>
    	<th> 영어 </th>
    	<th> 수학 </th>
    </tr>
	<%

	NumberDto dto2 = service.selectAvgAnalyze();
	
	%>
    <tr>
    	 <td><%=dto2.getKor() %></td>
    	 <td><%=dto2.getEng() %></td>
    	 <td><%=dto2.getMath() %></td>
    </tr>

</table>
<br>
<hr>
<table>
	<tr>
		<th> 전체 평균</th>
	</tr>
	<%
	double totalAvg = service.totalAvgAnalyze();
	%>
	<tr>
		<td><%= totalAvg %></td>
	</tr>
</table>
</body>
</html>