<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="result"></div>
<button id="btn" onclick="ajax()">클릭</button>
<script type="text/javascript">
function ajax() {
	let res = document.querySelector("#result");
	let xhr = new XMLHttpRequest();

	xhr.onload = () => {
	    if(xhr.status === 200) {
	        console.log("성공");
	        res.innerHTML = xhr.responseText;
	    }else{
	        console.log("실패");
	    }
	}

	xhr.open('get', 'view.jsp?num=3', true);
	xhr.send();
}

</script>
</body>
</html>