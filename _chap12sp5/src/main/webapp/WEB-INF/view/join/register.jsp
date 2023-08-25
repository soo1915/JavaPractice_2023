<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="css/register.css">
	<title>회원 가입</title>
</head>
<body>
	<div id="container">
		<h1>회원 가입</h1>
		<form:form method="post" id="register" modelAttribute="join">
			<ul id="user-info">
				<li>
					<label for="userid" class="field">아이디</label>
					<form:input path="userid" placeholder="4~15자리의 영문과 숫자로 입력" required="true"/><br>
					<form:errors path="userid"/>
				</li>
				<li>
					<label for="email" class="field">이메일</label>
					<form:input type="email" path="email" required="true"/><br>
					<form:errors path="email"/>
				</li>
				<li>
					<label for="userpw1" class="field">비밀번호</label>
					<form:password path="userpw1" placeholder="8자리 이상" required="true"/><br>
					<form:errors path="userpw1"/>
				</li>
				<li>
					<label for="userpw2" class="field">비밀번호 확인</label>
					<form:password path="userpw2" required="true"/><br>
					<form:errors path="userpw2"/>
				</li>
				<li>
					<label class="field">메일링 수신</label>
					<label class="r"><form:radiobutton value="true" path="mailing"/>예</label>
					<label class="r"><form:radiobutton value="false" path="mailing"/>아니오</label>
				</li>
			</ul>
			<ul id="buttons">
				<li>
					<button type="submit" class="btn btnBlack">가입하기</button>					
				</li>
				<li>
					<button type="reset" class="btn btnGray">취소</button>
				</li>
			</ul>
		</form:form>
	</div>
	
	<script src="js/register-result.js"></script>
</body>
</html>