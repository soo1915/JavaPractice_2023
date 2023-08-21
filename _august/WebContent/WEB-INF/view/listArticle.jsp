<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>메인 화면</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/offcanvas-navbar/">

	

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
      table{
        background: #fff;
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

      .pagination {
        justify-content: center;
      }

      .a {
        text-decoration: none;
      }

      #joinbtn{
		text-decoration: none;
	}
	
	#joinbtn:link{
		color:#0095f6;
	}
	#joinbtn:hover{
		color:#0095f6;
	}
	#joinbtn:visited{
		color:#0095f6;
	}
	#joinbtn:active {
		color:#87CEFA;
	}
    </style>

    
    <!-- Custom styles for this template -->
    <link href="${ctxPath }/css/offcanvas.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    
<nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark" aria-label="Main navigation">
  <div class="container-fluid">
    <a class="navbar-brand" href="list.do">게시판</a>
    <button class="navbar-toggler p-0 border-0" type="button" id="navbarSideCollapse" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
	<div class="navbar-collapse offcanvas-collapse" id="navbarsExampleDefault">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <u:isLogin>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/index.jsp">처음 화면으로</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/logout.do">로그아웃</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/changePwd.do">암호 변경</a>
        </li>
        </u:isLogin>
        <u:notLogin>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/index.jsp">처음 화면으로</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/join.do">회원가입</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active float-right"   aria-current="page" href="${ctxPath }/login.do">로그인하기</a>
        </li>
        </u:notLogin>
      </ul>
    </div>
  </div>
</nav>

<main class="container">
  <div class="d-flex align-items-center p-3 my-3 text-white bg-dark rounded shadow-sm">
    <!-- 로고 추후 수정 요망-->
    <img src="${ctxPath }/images/window-fullscreen_white.svg" class="me-3" alt="" width="48" height="38">
    <div class="lh-1">
      <h1 class="h6 mb-0 text-white lh-1">메인 화면</h1>
    </div>
  </div>
  <button type="button" class="btn btn-secondary btn btn-dark"  onclick="location.href='write.do';">내용 작성하기</button>
  <hr>
  <div class="bd-example">
    <table class="table table-striped table-hover">
    <thead>
      <tr>
        <th scope="col">번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
      </tr>
    </thead>
    <tbody>
    <c:if test="${articlePage.hasNoArticles()}">
	<tr>
		<td colspan="4">게시글이 없습니다.</td>
	</tr>
	</c:if>
	<c:forEach var="article" items="${articlePage.content}">
      <tr>
        <th scope="row">${article.number}</th>
        <td><a href="read.do?no=${article.number}&pageNo=${articlePage.currentPage}" id="joinbtn">
		<c:out value="${article.title}"/>
		</a>
		</td>
        <td>${article.writer.name}</td>
        <td>${article.readCount}</td>
      </tr>
    </c:forEach>
    </tbody>
    
    </table>
    <c:if test="${articlePage.hasArticles()}">
    <nav aria-label="Page navigation example">
      <ul class="pagination">
        <li class="page-item">
        <c:if test="${articlePage.startPage > 5}">
          <a href="list.do?pageNo=${articlePage.startPage - 5}" class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">이전</span>
            <span class="sr-only"></span>
          </a>
        </c:if>
        </li>
        <c:forEach var="pNo" begin="${articlePage.startPage}" end="${articlePage.endPage}">
        <li class="page-item"><a href="list.do?pageNo=${pNo}" class="page-link" href="#">${pNo}</a></li>
        </c:forEach>
        <li class="page-item">
        <c:if test="${articlePage.endPage < articlePage.totalPages}">
          <a href="list.do?pageNo=${articlePage.startPage + 5} class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">다음</span>
            <span class="sr-only"></span>
          </a>
        </c:if>
        </li>
      </ul>
    </nav>
    </c:if>
  </div>
  
</main>


    <script src="${ctxPath }/js/bootstrap.bundle.min.js"></script>

      <script src="${ctxPath }/js/offcanvas.js"></script>
  </body>
</html>
