<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="deptno">
<%
    // 게시글 리스트 읽어오기
    Class.forName("oracle.jdbc.driver.OracleDriver");
    try (
        Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
        Statement stmt = conn.createStatement();
    
        // 쿼리 실행
        ResultSet rs = stmt.executeQuery(
                "select deptno, dname from dept order by dname desc");           
    ) {
        // 게시글 레코드가 남아있는 동안 반복하며 화면에 출력
        while (rs.next()) {
%>

<option value="<%=rs.getInt("deptno") %>"><%=rs.getString("dname") %></option>
<%
        }
    } catch(Exception e) {
        e.printStackTrace();
    }
%>
</select>
<button id="btn">클릭</button>
<div id="result"></div>
<script type="text/javascript">

var btn = document.getElementById("btn");

btn.addEventListener("click", ()=>{
	var res = document.getElementById("result");
	var deptno = document.getElementById("deptno");
	var dnum = deptno.options[deptno.selectedIndex].value;
	console.log(dnum);
	var xhr = new XMLHttpRequest();
	xhr.open('get','emp.jsp?dnum='+dnum, true); // 동기화 여부
	xhr.send();
	
	xhr.onload = ()=> {
		if(xhr.status == 200) {
			console.log(xhr.responseText);
            res.innerHTML = xhr.responseText;
		}else{
			console.log("통신 오류");
		}
	}
});
</script>
</body>
</html>