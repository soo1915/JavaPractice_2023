<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ page import="guestbook.service.DeleteMessageService" %> --%>
<%-- <%@ page import="guestbook.service.InvalidPassowrdException" %> --%>
<%-- <% --%>
// 	int messageId = Integer.parseInt(request.getParameter("messageId"));
// 	String password = request.getParameter("password");
// 	boolean invalidPassowrd = false;
// 	try {
// 		DeleteMessageService deleteService = 
// 				DeleteMessageService.getInstance();
// 		deleteService.deleteMessage(messageId, password);
// 	} catch(InvalidPassowrdException ex) {
// 		invalidPassowrd = true;
// 	}
<%-- %> --%>
<html>
<head>
	<title>방명록 메시지 삭제함</title>
</head>
<body>
<c:if test="${!invalidPassowrd }">
메시지를 삭제하였습니다.
</c:if>
<c:if test="${invalidPassowrd }">
입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
</c:if>
<br/>
<a href="list.do">[목록 보기]</a>
</body>
</html>