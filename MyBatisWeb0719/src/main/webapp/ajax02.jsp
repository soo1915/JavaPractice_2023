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
<input type="text" id="thing" />
<button id="btn">보내기</button>
<script>
    const btn = document.getElementById("btn");
    const res = document.getElementById("result");
    
    btn.addEventListener("click", ()=>{
    	const thing = document.getElementById("thing").value;
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'AjaxPost', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send("thing=" + thing);
        
        xhr.onload = ()=>{
            if(xhr.status == 200) {
                //console.log(xhr.response);
                console.log(xhr.responseText);
                res.innerHTML = xhr.responseText;
            }
        }
    })
</script>
</body>
</html>