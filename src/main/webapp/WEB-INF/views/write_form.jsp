<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
</head>
<body>
	<h2>자유게시판 글쓰기</h2>
	<hr>
	<form action="writeOk">
		<table border="1" cellspacing="0" cellpadding="0" width="600">
			<tr>
				<td>이 름 </td>
				<td><input type="text" name="bname" width="60"></td>
			</tr>
			<tr>
				<td>제 목 </td>
				<td><input type="text" name="btitle" width="60"></td>
			</tr>
			<tr>
				<td>내 용 </td>
				<td><textarea name="bcontent" rows="10" cols="45"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="글입력"> 
					<input type="button" value="글목록" onClick="javascript:window.location.href='list'">
				</td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>