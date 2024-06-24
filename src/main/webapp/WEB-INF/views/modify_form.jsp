<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style>
	input.cantModify {
		width: ;
		height: ;
		font-size: ;
		border: 0;
	}
</style>
</head>
<body>
	<h2>자유게시판 글 수정</h2>
	<hr>
	<form action="modifyOk">
		<table border="1" cellspacing="0" cellpadding="3" width="600">
			<tr>
				<td>글번호</td>
				<td><input type="text" class="cantModify"name="bnum" value="${bDto.bnum}"></td>
			</tr>
			<tr>
				<td>이&nbsp;&nbsp;름 </td>
				<td><input type="text" class="cantModify" name="bname" width="60" value="${bDto.bname}" readonly="readonly"></td>
			</tr>
			<tr>
				<td>제&nbsp;&nbsp;목 </td>
				<td><input type="text" name="btitle" width="60" value="${bDto.btitle}"></td>
			</tr>
			<tr>
				<td>내&nbsp;&nbsp;용 </td>
				<td><textarea name="bcontent" rows="10" cols="45">${bDto.bcontent}</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정"> 
					<input type="button" value="삭제" onClick="javascript:window.location.href='delete?bnum=${bDto.bnum}'">
					<input type="button" value="목록" onClick="javascript:window.location.href='list'">
				</td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>