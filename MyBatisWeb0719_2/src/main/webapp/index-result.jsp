<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
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
			<button type="button" id="add" class="addBtn">추가</button>
		</form>
		<div id="itemList">
			${list}
		</div>
	</div>    
	
	<script src="js/checklist-result1.js"></script>
	<script type="text/javascript">
	//alert(itemList);
	//itemList = [{idx:10, thing:'양말'},{idx:20, thing:'수건'},{idx:30, thing:'가방'}];
	//showList();
	</script>
	</html>