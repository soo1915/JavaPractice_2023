<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="jsp0607.*"%>
<%
	String animal = request.getParameter("animal");
	String str;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>선택된 동물 : <%= animal %></p><br>
	<%
		Feed feed = new Feed();
	
		Dog dog = new Dog();
		Cat cat = new Cat();
		Turtle turtle = new Turtle();
		
		if (animal.equals("cat")) {
			str = feed.feed(cat);
		} else if (animal.equals("dog")) {
			str = feed.feed(dog);
		} else {
			str = feed.feed(turtle);
		}
	%>
	<%= str %>
	
</body>
</html>