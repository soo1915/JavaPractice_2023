<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();

	if (cookies != null && cookies.length > 0) {
		
		for (int i = 0; i < cookies.length; i++ ){
			if (cookies[i].getName().equals("name1")) {
				Cookie cookie1 = new Cookie("name1", "");
				cookie1.setMaxAge(0);
				response.addCookie(cookie1);
			}
		}
	}
%>
</body>
</html>