<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>암호 변경</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

    

    <!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

    <style>
    body {
      min-height: 100vh;

      background: -webkit-gradient(linear, left bottom, right top, from(#92b5db), to(#1d466c));
      background: -webkit-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -moz-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: -o-linear-gradient(bottom left, #92b5db 0%, #1d466c 100%);
      background: linear-gradient(to top right, #92b5db 0%, #1d466c 100%);
    }

      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      .a {
        text-decoration: none;
      }
      #joinbtn{
		text-decoration: none;
	}
	#joinbtn:link{
		color:#ffffff;
	}
	#joinbtn:hover{
		color:#ffffff;
	}
	#joinbtn:visited{
		color:#ffffff;
	}
	#joinbtn:active {
		color:#87CEFA;
	}

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <link href="css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form action="changePwd.do" method="post">
    <!-- 이미지 추후 수정 -->
    <img class="mb-4" src=".\images\bootstrap-logo-white.svg" alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">비밀번호 변경</h1>
	<hr class="my-4">
    <div class="form-floating">
      <input type="password" name="curPwd" class="form-control" id="floatingInput" placeholder="현재 비밀번호">
      <label for="floatingPassword">현재 비밀번호<c:if test="${errors.curPwd}">현재 비밀번호</c:if></label>
      <c:if test="${errors.badCurPwd}">현재 암호가 일치하지 않습니다.</c:if>
    </div>
    <br>
    <div class="form-floating">
      <input type="password" name="newPwd" class="form-control" id="floatingPassword" placeholder="변경 비밀번호">
      <label for="floatingPassword">변경 비밀번호<c:if test="${errors.newPwd}">변경 비밀번호</c:if></label>
    </div>

    
    <button class="w-100 btn btn-lg btn-primary" type="submit">변경하기</button>
    <!--<p class="mt-5 mb-3 text-muted">&copy; 2023</p> 저작권 관련 내용-->
  </form>
</main>


    
  </body>
</html>
