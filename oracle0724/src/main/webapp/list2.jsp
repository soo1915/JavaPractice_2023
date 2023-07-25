<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

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
<c:forEach var="dto" items="${list}">       
        <tr>
            <td>${dto.num}</td>
            <td style="text-align:left;">
                <!-- <a href="#" onclick="ajax(${dto.num})"> -->
                <a href="${pageContext.request.contextPath}/view?num=${dto.num}">
                    ${dto.title}
                </a>
            </td>
            <td>${dto.writer}</td>
            <td>${dto.regtime}</td>
            <td>${dto.hits}</td>
        </tr>
</c:forEach>
</table>

<br>
<input type="button" value="글쓰기" onclick="location.href='${pageContext.request.contextPath}/write'">
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

    xhr.open("get", "view?num="+num, true);
    xhr.send();
}
</script>
</body>
</html>
