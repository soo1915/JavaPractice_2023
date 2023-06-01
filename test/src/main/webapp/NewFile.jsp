<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%int num1= (int)(Math.random()*45)+1;
	int num2= (int)(Math.random()*45)+1;
	int num3= (int)(Math.random()*45)+1;
	int num4= (int)(Math.random()*45)+1;
	int num5= (int)(Math.random()*45)+1;
	int num6= (int)(Math.random()*45)+1;
	
	
	while(true) {
		if(num1==num2||num1==num3||num1==num4||num1==num5||num1==num6
		||num2==num3||num2==num4||num2==num5||num2==num6
		||num3==num4||num3==num5||num3==num6
		||num4==num5||num4==num6
		||num5==num6) {
			num1 = (int)(Math.random()*45)+1;
			num2 = (int)(Math.random()*45)+1;
			num3 = (int)(Math.random()*45)+1;
			num4 = (int)(Math.random()*45)+1;
			num5 = (int)(Math.random()*45)+1;
			num6 = (int)(Math.random()*45)+1;
			} else {
	%>
				<%=num1 %>,<%=num2 %>,<%=num3 %>,<%=num4 %>,<%=num5 %>,<%=num6 %>
				
				<%
				break;
				 
		}
	} 
	%>
</body>
</html>