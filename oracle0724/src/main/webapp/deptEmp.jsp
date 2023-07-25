<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<select id="deptno">
<option value="10">10번 부서</option>
<option value="20">20번 부서</option>
<option value="30">30번 부서</option>
</select>
<button id="btn">클릭</button>
<div id="result"></div>
<script type="text/javascript">

var btn = document.getElementById("btn");

btn.addEventListener("click", ()=>{
	var res = document.getElementById("result");
	var deptno = document.getElementById("deptno");
	var dnum = deptno.options[deptno.selectedIndex].value;
	console.log(dnum);
	var xhr = new XMLHttpRequest();
	xhr.open('get','emp.jsp?dnum='+dnum, true); // 동기화 여부
	xhr.send();
	
	xhr.onload = ()=> {
		if(xhr.status == 200) {
			console.log(xhr.responseText);
            res.innerHTML = xhr.responseText;
		}else{
			console.log("통신 오류");
		}
	}
});
</script>
</body>
</html>