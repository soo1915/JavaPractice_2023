<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width">
	<title>여행 준비물 점검 목록</title>
	<link rel="stylesheet" href="css/input.css">
	<link rel="stylesheet" href="css/list.css">
</head>
<body>


	<div id="wrapper">
		<h2>여행 준비물 점검 목록</h2>
		<form>
			<input type="text" id="item" autofocus="true">
			<button type="button" id="add" class="addBtn" onclick="ajax()">추가</button>
		</form>
		<div id="itemList"></div>
	</div>    
	<script>
	var btn = document.getElementById("add");
	var res = document.getElementById("itemList");
	function ajax() {
		var xhr = new XMLHttpRequest();
		xhr.open('GET', 'SelTrip', true);
		xhr.send();
		
		xhr.onload = ()=> {
			if(xhr.status == 200) {
				//console.log(xhr.responseText);
				res.innerHTML = xhr.responseText;
			}
		}

	}
	</script>
	
	</html>