<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글</h2>
	<hr>
	<h3>${bDto.btitle}</h3>
	작성자: ${bDto.bname} &emsp;| &emsp;작성시간: ${bDto.bdate} &emsp;| &emsp;조회수: ${bDto.bhit}
	<hr style="border: 0 solid gainsboro; height: 1px;">
	<p>${bDto.bcontent}</p>
	<!-- 수정 / 삭제 / 글 목록 -->
	<form action="modify">
		<input type="hidden" name="bnum" value="${bDto.bnum}">
		<table>
			<tr>
				<td><input type="submit" value="수정"></td>
				<td><button type="button" onClick="javascript:window.location.href='delete?bnum=${bDto.bnum}'">삭제</button></td>
				<td><button type="button" onClick="javascript:window.location.href='list'">목록</button></td>
			</tr>
		</table>
	</form>
</body>
</html>