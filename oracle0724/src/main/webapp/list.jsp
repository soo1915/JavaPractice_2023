<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.*" %>
<%@ page import="board.oracle.*" %>
<%
BoardDao dao = new BoardDao();
ArrayList<BoardDto> list = dao.selectList();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <style>
        table     { width:680px; text-align:center; }
        th        { background-color:cyan; }
        
        .num      { width: 80px; }
        .title    { width:230px; }
        .writer   { width:100px; }
        .regtime  { width:180px; }
                
        a:link    { text-decoration:none; color:blue; }
        a:visited { text-decoration:none; color:gray; }
        a:hover   { text-decoration:none; color:red;  }
    </style>
</head>
<body>
<div id="result"></div>
<table>
    <tr>
        <th class="num"    >번호    </th>
        <th class="title"  >제목    </th>
        <th class="writer" >작성자  </th>
        <th class="regtime">작성일시</th>
        <th                >조회수  </th>
    </tr>
<%
for(BoardDto dto : list) {   
%>         
        <tr>
            <td><%=dto.getNum()%></td>
            <td style="text-align:left;">
                <a href="#" onclick="ajax(<%=dto.getNum()%>)">
                    <%=dto.getTitle()%>
                </a>
            </td>
            <td><%=dto.getWriter()%></td>
            <td><%=dto.getRegtime()%></td>
            <td><%=dto.getHits()%></td>
        </tr>
<%
}  
%>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='write.jsp'">
<script>
function ajax(num) {
    var res = document.getElementById("result");
    //var btn = document.getElementById("btn");
    var xhr = new XMLHttpRequest(); 

    xhr.onreadystatechange = function() {
      if (xhr.readyState === 4) {
        if (xhr.status === 200) {
        	console.log(xhr.responseText);
            res.innerHTML = xhr.responseText;
        }
      }
    };

    xhr.open("get", "view.jsp?num="+num, true);
    xhr.send();
}
</script>
</body>
</html>
