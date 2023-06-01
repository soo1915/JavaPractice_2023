<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="static0601.*" %>    
<%
	Singleton st = Singleton.getInstance();
	String name = request.getParameter("name");
	String kor = request.getParameter("kor");
	String math = request.getParameter("math");
	String eng = request.getParameter("eng");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action ="">
	이름<input type = "text" name = "name" /><br>
	국어<input type = "text" name = "kor" /><br>
	수학<input type = "text" name = "math" /><br>
	영어<input type = "text" name = "eng" /><br>
	<input type = "submit" />
</form>
<br>
<%
	if ((kor != null) || (math != null) || (eng != null)) {
		int index = st.getIndex();
		st.stu[index].setName(name);	
		st.stu[index].setKor(Integer.parseInt(kor));
		st.stu[index].setMath(Integer.parseInt(math));
		st.stu[index].setEng(Integer.parseInt(eng));
	}
	
%>
<table border = "1">
	<tr>
		<th>이름</th>
		<th>국어 점수</th>
		<th>수학 점수</th>
		<th>영어 점수</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	
	<%
		for (int i = 0; i < st.stu.length; i++) {
		
	%>
	<tr>
		<td><%= st.stu[i].getName() %></td>
		<td><%= st.stu[i].getKor() %></td>
		<td><%= st.stu[i].getMath() %></td>
		<td><%= st.stu[i].getEng() %></td>
		<td><%= st.stu[i].getSum() %>
		<td><%= st.stu[i].getAvg() %>
	</tr>
	
	<%
		}
	%>
	
</table>
</body>
</html>