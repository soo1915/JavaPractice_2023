<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<title>연습문제 1</title>
	<link rel="stylesheet" href="css/sol-1.css">
</head>
<body>
	<div id="container">
    <h1>피자 주문</h1>
		<form:form method="post" modelAttribute="plist">
      <fieldset>
        <legend>사이즈</legend>
        <p>Large - 24000 원 </p>
      </fieldset>
      <fieldset>
        <legend>추가 주문 </legend>        
          <label><form:checkbox path="plist[0].addorder" class="checkbx" value="800" label="피클(800원)"/></label>
          <label><form:checkbox path="plist[1].addorder" class="checkbx" value="300" label="칠리 소스(300원)"/></label>
          <label><form:checkbox path="plist[2].addorder" class="checkbx" value="200" label="디핑 소스(200원)"/></label>
          <label><form:checkbox path="plist[3].addorder" class="checkbx" value="4800" label="치즈스틱(4개, 4800원)"/></label>
          <label><form:checkbox path="plist[4].addorder" class="checkbx" value="2400" label="콘 샐러드(2400원)"/></label>        
      </fieldset>
      <fieldset>
        <legend>합계</legend>
        <form:input path="total" class="price" readonly="true" />
      </fieldset>
      <input type="submit" />
		</form:form>	
	</div>

	<script src="js/sol-1.js"></script>
</body>
</html>