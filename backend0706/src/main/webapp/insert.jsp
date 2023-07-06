<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="backend0706.*" %>

<% 
	request.setCharacterEncoding("utf-8");
	
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String part = request.getParameter("part");
	String content = request.getParameter("content");

	if (name  == null || name.length()  == 0 ||
        phone == null || phone.length() == 0 ||
        part == null || part.length() == 0 || 
        content == null || content.length() == 0) {
%>

<script>
	alert('모든 항목이 빈칸 없이 입력되어야 합니다.');
	history.back();
</script>
<%        
        return;
    }
	ResumeDto dto = new ResumeDto(0, name, phone, part, content, "");
    ResumeDao dao = new ResumeDao();
	dao.insertResume(dto);
    
    // 목록보기 화면으로 돌아감
    response.sendRedirect("home.jsp");
%>  