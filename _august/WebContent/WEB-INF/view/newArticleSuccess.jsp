<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>게시글 등록 완료</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/sign-in/">

     ${ctxPath = pageContext.request.contextPath ; ''}

    <!-- Bootstrap core CSS -->
<link href="${ctxPath }/css/bootstrap.min.css" rel="stylesheet">

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
      
      .find-btn {
        text-align: center;
      }
      
      #joinbtn, #checkbtn{
		text-decoration: none;
	}
	#joinbtn, #checkbtn:link{
		color:#ffffff;
	}
	#joinbtn, #checkbtn:hover{
		color:#ffffff;
	}
	#joinbtn, #checkbtn:visited{
		color:#ffffff;
	}
	#joinbtn, #checkbtn:active {
		color:#87CEFA;
	}

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <link href="${ctxPath }/css/signin.css" rel="stylesheet">
  </head>
  <body class="text-center">
    
<main class="form-signin">
  <form >
    <!-- 이미지 추후 수정 -->
    
    <h1 class="h3 mb-3 fw-normal">글 작성 성공!</h1>

    <br>
<%--     ${ctxPath = pageContext.request.contextPath ; ''} --%>
	<div class="find-btn">
    <button class="w-30 btn btn-primary btn-sm btn-dark" type="button"><a id="joinbtn" href="${ctxPath}/article/list.do">목록으로 이동하기</a></button>
    <button class="w-30 btn btn-primary btn-sm btn-dark" type="button"><a id="checkbtn" href="${ctxPath}/article/read.do?no=${newArticleNo}">작성 내용 확인</a></button>
    <!--<p class="mt-5 mb-3 text-muted">&copy; 2023</p> 저작권 관련 내용-->
 	</div>
  </form>
</main>


    
  </body>
</html>
