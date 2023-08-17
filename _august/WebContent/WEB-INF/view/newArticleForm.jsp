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
    <title>게시글 작성</title>

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
        <form class="needs-validation " action="write.do" method="post" novalidate>
          <div>
            <div class="col-sm-6">
              <label for="firstName" class="form-label">제목</label>
              <input type="text" class="form-control" id="firstName" placeholder="" name="title" value="${param.title}" required>
            </div>
          </div>
          <br>

          <div >
              <label for="zip" class="form-label">내용</label>
              <div class="form-group">
                <textarea name="content" class="form-control h-25" id="exampleFormControlTextarea1" rows="10"  cols="30">${param.title}</textarea>
              </div>
              <div class="invalid-feedback">
                내용을 입력하세요
              </div>
          </div>
          <hr class="my-4">
          <button class="w-100 btn btn-primary btn-lg btn-dark" type="submit">등록하기</button>
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
