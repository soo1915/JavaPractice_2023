<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="insertServ">
    <table>
        <tr>
            <th>제목</th>
            <td><input type="text" name="title"  maxlength="80"/>
            </td>
        </tr>
        <tr>
            <th>작성자</th>
            <td><input type="text" name="writer" maxlength="20"/>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="10"></textarea>
            </td>
        </tr>
    </table>

    <br>
    <input type="submit" value="저장">
    <input type="reset" value="취소">
</form>
</body>
</html>