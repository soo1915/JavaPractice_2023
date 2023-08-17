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
    <title>글 확인</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">

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

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }

      .container.now {
        max-width: 680px;

      padding: 32px;

      background: #fff;
      -webkit-border-radius: 10px;
      -moz-border-radius: 10px;
      border-radius: 10px;
      -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
      box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15)
      }
      #listbtn, #modifybtn, #delbtn{
		    text-decoration: none;
      }

      #listbtn, #modifybtn, #delbtn :link{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn:hover{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn:visited{
        color:#ffffff;
      }
      #listbtn, #modifybtn, #delbtn:active {
        color:#ffffff;
      }

      .find-btn {
        text-align: center;
      }
      
    </style>

    
    <!-- Custom styles for this template -->
    <link href="${ctxPath }/css/form-validation.css" rel="stylesheet">
  </head>
  <body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      
    </div>

    <div class="container now" style="float:none; margin: 100 auto;">
      <div>
        <h4 class="mb-3">내용 작성</h4>
        <form class="needs-validation "  novalidate>
          <div>
            <div class="col-sm-6">
              <label for="firstName" class="form-label">번호</label>
              <input type="text" class="form-control" id="firstName" placeholder="${articleData.article.number}" value="" readonly>
            </div>
            <br>
            <div class="col-sm-6">
              <label for="firstName" class="form-label">작성자</label>
              <input type="text" class="form-control" id="firstName" placeholder="${articleData.article.writer.name}" value="" readonly>
            </div>
            <br>
            <div class="col-sm-6">
              <label for="firstName" class="form-label">제목</label>
              <input type="text" class="form-control" id="firstName" placeholder="" value="${articleData.article.title}" readonly>
            </div>
            <br>
            
          </div>
          <br>

          <div >
              <label for="zip" class="form-label">내용</label>
              <div class="form-group">
                <textarea class="form-control h-25" id="exampleFormControlTextarea1" rows="10" readonly><u:pre value='${articleData.content}'/></textarea>
              </div>
          </div>
          <hr class="my-4">
          <div class="find-btn">
          	<c:set var="pageNo" value="${empty param.pageNo ? '1' : param.pageNo}" />
            <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="listbtn" href="list.do?pageNo=${pageNo}">목록</a></button>
            <c:if test="${authUser.id == articleData.article.writer.id}">
            <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="modifybtn" href="modify.do?no=${articleData.article.number}">게시글 수정</a></button>
            <button class="w-30 btn btn-primary btn-lg btn-dark" type="button"><a id="delbtn" href="delete.do?no=${articleData.article.number}">게시글 삭제</a></button>
          	</c:if>
          </div>
        </form>
      </div>
      </div>
    </div>
  </main>
</div>
    <script src="${ctxPath }/js/bootstrap.bundle.min.js"></script>

      <script src="${ctxPath }/js/form-validation.js"></script>
  </body>
</html>
