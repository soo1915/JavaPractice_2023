<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="backend0706.*" %>
<%
ResumeDao dao = new ResumeDao();
ArrayList<ResumeDto> list = dao.selectList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body      { text-align : center;}
	table     { width:680px; text-align:center; margin : auto;}
	th        { background-color:cyan; }
	
	.num      { width: 80px; }
	.name    { width:100px; }
	.part   { width:230px; }
	.writedate  { width:180px; }
	        
	a:link    { text-decoration:none; color:blue; }
	a:visited { text-decoration:none; color:gray; }
	a:hover   { text-decoration:none; color:red;  }
</style>
</head>
<body>
<h2>지원자 리스트</h2>
<p>지원서 상세보기를 원하시면 이름을 클릭해주세요.</p>
<hr>
<table>
    <tr>
        <th class="num"      >번호  </th>
        <th class="name"     >이름  </th>
        <th class="part"     >지원분야</th>
        <th class="writedate">작성일시</th>
    </tr>
<%
    for(ResumeDto dto : list) {
    
%> 
	<tr>
	    <td><%=dto.getNum()%></td>
	    <td style="text-align:center;">
	        <a href="view.jsp?num=<%=dto.getNum()%>">
	            <%=dto.getName()%>
	        </a>
	    </td>
	    <td><%=dto.getPart()%></td>
	    <td><%=dto.getWritedate()%></td>
	</tr>
<%
    }
%>
</table>
</body>
</html>