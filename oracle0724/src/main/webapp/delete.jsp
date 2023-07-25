<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="board.oracle.*" %>
    
<%
    // 지정된 글 번호 얻기
    int num = Integer.parseInt(request.getParameter("num"));

	BoardDao dao = new BoardDao();
	dao.deleteOne(num);
    
    // 목록보기 화면으로 돌아감
    response.sendRedirect("list2.jsp");
%>