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
<button id = "btn" onclick="ajax()"> 클릭</button>
<script>
function ajax() {
    var res = document.getElementById("result");
    //var btn = document.getElementById("btn");
    var xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function(){
        if (xhr.readyState === 4) {
            if(xhr.status === 200) {
                console.log(xhr.responseText);
                res.innerHTML = xhr.responseText;
            }
        }
    };

xhr.open("get", "aaa.jsp?name=홍길철", true);
xhr.send(null);
} 
</script>
</body>
</html>