<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en" class="h-100">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>메인 화면</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/cover/">

    

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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      #listbtn, #modifybtn, #delbtn, #joinbtn, #loginbtn, #artbtn{
		    text-decoration: none;
      }

      #listbtn, #modifybtn, #delbtn, #joinbtn, #loginbtn, #artbtn :link{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn, #joinbtn, #loginbtn, #artbtn :hover{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn, #joinbtn, #loginbtn, #artbtn :visited{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn, #joinbtn, #loginbtn, #artbtn :active {
        color:#ffffff;
      }
      
      .find-btn {
        text-align: center;
      }
    </style>

    
    <!-- Custom styles for this template -->
    <link href="css/cover.css" rel="stylesheet">
  </head>
  <body class="d-flex h-100 text-center text-white bg-dark">
    
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
  <header class="mb-auto">
    <div>
      <h3 class="float-md-start mb-0">Cover</h3>
      <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
        <div class="container-fluid">
          <a class="navbar-brand" href="#">게시판</a>
          <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
        </div>
      </nav>
    </div>
  </header>

  <main class="px-3">
    
    <u:isLogin>
      <div class="find-btn">
      	<h1>${authUser.name}님, 환영합니다!</h1>
	    <p class="lead"></p>
	    <br>
	    <p class="lead">
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="listbtn" href="logout.do">로그아웃</a></button>
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="modifybtn" href="changePwd.do">암호 변경</a></button>
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="delbtn" href="article/list.do">게시판</a></button>
     	</p>
      </div>
    </u:isLogin>
    <u:notLogin>
    <div class="find-btn">
    	<h1>Welcome!</h1>
	    <p class="lead"></p>
	    <br>
	    <p class="lead">
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="joinbtn" href="join.do">회원가입</a></button>
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="loginbtn" href="login.do">로그인</a></button>
        <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="artbtn" href="article/list.do">게시판</a></button>
      	</p>
      </div>
    </u:notLogin>
    
  </main>

  <footer class="mt-auto text-white-50">
    
  </footer>
</div>


    
  </body>
</html>
