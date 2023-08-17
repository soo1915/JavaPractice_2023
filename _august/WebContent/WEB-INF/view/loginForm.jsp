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
    <title>로그인</title>

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
  <form action="login.do" method="post">
    <!-- 이미지 추후 수정 -->
    <img class="mb-4"  alt="" width="72" height="57">
    <h1 class="h3 mb-3 fw-normal">로그인</h1>
	<hr class="my-4">
	<c:if test="${errors.idOrPwNotMatch}">
	아이디와 암호가 일치하지 않습니다.
	</c:if>
    <div class="form-floating">
      <input type="text" class="form-control" name="id" id="floatingInput" value="${param.id}">
      <label for="floatingInput">아이디</label>
      <c:if test="${errors.id}">ID를 입력하세요.</c:if>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" name="password">
      <label for="floatingPassword">비밀번호</label>
      <c:if test="${errors.password}">암호를 입력하세요.</c:if>
    </div>

    <div class="checkbox mb-3">
      <label>
        계정이 없으신가요? 
        <a id="joinbtn" href=service.jsp>회원가입</a>
      </label>
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
    <!--<p class="mt-5 mb-3 text-muted">&copy; 2023</p> 저작권 관련 내용-->
  </form>
</main>


    
  </body>
</html>
