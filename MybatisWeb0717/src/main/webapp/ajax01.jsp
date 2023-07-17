<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id = "result"></div>
<button id = "btn">보내기</button>
<script>
	var btn = document.getElementById("btn");
	var res = document.getElementById("result");
	btn.addEventListener("click", ()=>{
		var xhr = new XMLHttpRequest();
		xhr.open('GET', 'ExecAjax', true);
		xhr.send();
		
		xhr.onload = ()=> {
			if(xhr.status == 200) {
				console.log(xhr.responseText);
				res.innerHTML = xhr.responseText;
			}
		}
	})
	
</script>
</body>
</html>