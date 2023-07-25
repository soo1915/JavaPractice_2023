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
<button onclick="ajax()">클릭</button>
<div id="result"></div>
<script type="text/javascript">
function ajax() {
	let deptno = document.querySelector("#deptno");
	let dnum = deptno.options[deptno.selectedIndex].value;
	var res = document.getElementById("result");
	let xhr = new XMLHttpRequest();

	xhr.onload = () => {
	    if(xhr.status === 200) {
	        console.log("성공");
	        res.innerHTML = xhr.responseText;
	    }else{
	        console.log("실패");
	    }
	}

	xhr.open('get', 'emp.jsp?dnum='+dnum, true);
	xhr.send();
}

</script>
</body>
</html>